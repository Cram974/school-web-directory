import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Hashtable;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ContactCtrl extends HttpServlet{
  private static String INDEX = "/WEB-INF/views/list.jsp";
  private static String SHOW = "/WEB-INF/views/show.jsp";
  private static String EDIT = "/WEB-INF/views/edit.jsp";

  private Directory directory;

  public ContactCtrl(){
    super();
  }

  @Override
  public void init(ServletConfig config)
	throws ServletException{
    super.init(config);

    //Loading the data
    this.directory = new Directory();
    try{
      String path = this.getServletContext().getRealPath("/WEB-INF/data/database.xml");
      this.directory.loadXML(path);
    }
    catch(Exception e){
    }
  }

  @Override
  public void destroy(){
    String path = this.getServletContext().getRealPath("/WEB-INF/data/")+"/database.xml";
    this.directory.saveXML(path);
  }

  protected void handleIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("contacts", this.directory.elements());
    RequestDispatcher view = request.getRequestDispatcher(INDEX);
    view.forward(request, response);
  }

  protected void handleDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try{
      int id = Integer.parseInt(request.getParameter("id"));
      this.directory.remove(id);
    } catch(NumberFormatException e){

    }
    response.sendRedirect("contact");
  }

  protected void handleCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    RequestDispatcher view = request.getRequestDispatcher(EDIT);
    view.forward(request, response);
  }

  protected void handleShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try{
      int id = Integer.parseInt(request.getParameter("id"));
      request.setAttribute("contact", this.directory.get(id));
    } catch(NumberFormatException e){

    }
    RequestDispatcher view = request.getRequestDispatcher(SHOW);
    view.forward(request, response);
  }

  protected void handleEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try{
      int id = Integer.parseInt(request.getParameter("id"));
      request.setAttribute("contact", this.directory.get(id));
      request.setAttribute("contactID", id);
    } catch(NumberFormatException e){

    }
    RequestDispatcher view = request.getRequestDispatcher(EDIT);
    view.forward(request, response);
  }

  protected void handleSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //Retrieve the search query
    String query = request.getParameter("query").toLowerCase();

    //If no query then list all contacts
    if(query == null || query.equals("")){
        response.sendRedirect("contact");
    }else{
      List<Contact> result = new ArrayList<Contact>();
      Enumeration<Contact> e = this.directory.elements();

      //Search through names
      while(e.hasMoreElements()){
        Contact c = e.nextElement();
        String name = c.getFirstName() + " " + c.getLastName();
        if(name.toLowerCase().contains(query)){
          result.add(c);
        }
      }

      //Send the query and result to the view
      request.setAttribute("query", query);
      request.setAttribute("contacts", result);
      RequestDispatcher view = request.getRequestDispatcher(INDEX);
      view.forward(request, response);
      }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) action = "";
        switch(action){
            case "delete":
              this.handleDelete(request, response);
              break;
            case "edit":
              this.handleEdit(request, response);
              break;
            case "show":
              this.handleShow(request, response);
              break;
            case "create":
              this.handleCreate(request, response);
              break;
            case "search":
              this.handleSearch(request, response);
              break;
            default:
              this.handleIndex(request, response);
        }
    }

  protected void contactFromRequest(Contact contact, HttpServletRequest request){
    contact.setFirstName(request.getParameter("firstname"));
    contact.setLastName(request.getParameter("lastname"));
    contact.setPhoneNumber(request.getParameter("phone"));
    contact.setAddress(request.getParameter("address"));
    contact.setEmail(request.getParameter("email"));
    contact.setComment(request.getParameter("comment"));
  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if(idStr == null || idStr.equals("")){
          Contact contact = new Contact();
          this.contactFromRequest(contact, request);
          this.directory.add(contact);
        }else{
          try{
            int id = Integer.parseInt(idStr);
            this.contactFromRequest(this.directory.get(id), request);
          } catch(NumberFormatException e){

          }
        }

        response.sendRedirect("contact");
    }
}
