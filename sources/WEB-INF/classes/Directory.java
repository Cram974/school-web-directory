import java.io.*;
import org.jdom2.*;
import org.jdom2.output.*;
import org.jdom2.input.*;
import org.jdom2.filter.*;
import java.util.List;
import java.util.Iterator;
import java.util.Hashtable;
import java.io.InputStream;
import java.util.Enumeration;

public class Directory extends Hashtable<Integer,Contact>
{
  private int next_id;

  public Directory(){
    this.next_id = 1;
  }

  private String getElementField(Element e, String field){
    Element fieldElt = e.getChild(field);
    if(fieldElt == null){
      return "";
    }else{
      return fieldElt.getText();
    }
  }

  public void add(Contact contact){
    contact.setId(this.next_id);
    this.put(this.next_id++, contact);
  }

  public void log(String s){
    Contact c = new Contact();
    c.setFirstName(s);
    this.add(c);
  }

  public void loadXML(String path){
    this.clear();
    SAXBuilder sxb = new SAXBuilder();
    try {
      org.jdom2.Document document = sxb.build(new File(path));
      Element root = document.getRootElement();
      List contactList = root.getChildren("contact");
      Iterator i = contactList.iterator();
      while(i.hasNext())
      {
        Element e = (Element)i.next();

        Contact c = new Contact();

        c.setId(e.getAttribute("id").getIntValue());
        c.setFirstName(this.getElementField(e, "firstname"));
        c.setLastName(this.getElementField(e, "lastname"));
        c.setPhoneNumber(this.getElementField(e, "phone"));
        c.setAddress(this.getElementField(e, "address"));
        c.setEmail(this.getElementField(e, "email"));
        c.setComment(this.getElementField(e, "comment"));

        this.put(c.getId(), c);

        if(c.getId() > this.next_id){
          this.next_id = c.getId() + 1;
        }
      }
    }
    catch(Exception e){
      this.log(e.toString());
    }
  }

  public void saveXML(String path){
    try {
      Element root = new Element("directory");
      Enumeration<Contact> contacts = this.elements();
      while(contacts.hasMoreElements()){
        Contact c = contacts.nextElement();

        Element e = new Element("contact");
        e.setAttribute(new Attribute("id", ""+c.getId()));
        e.addContent(new Element("lastname").setText(c.getLastName()));
        e.addContent(new Element("firstname").setText(c.getFirstName()));
        e.addContent(new Element("phone").setText(c.getPhoneNumber()));
        e.addContent(new Element("address").setText(c.getAddress()));
        e.addContent(new Element("email").setText(c.getEmail()));
        e.addContent(new Element("comment").setText(c.getComment()));

        root.addContent(e);
      }

  	  DocType doctype = new DocType("directory", "../data/directory.dtd");
      Document document = new Document(root, doctype);

  		XMLOutputter xmlOutput = new XMLOutputter();

  		xmlOutput.setFormat(Format.getPrettyFormat());
  		xmlOutput.output(document, new FileWriter(path));

	  } catch (Exception e) {
	  }
  }
}
