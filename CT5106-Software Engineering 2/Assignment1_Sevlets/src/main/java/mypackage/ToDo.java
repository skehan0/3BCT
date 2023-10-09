package mypackage;

/**
 *
 * @author skeha
 */
public class ToDo {
    private String subject;
    private String details;
    
    // Constructor
    public ToDo(String subject, String details) {
        this.subject = subject;
        this.details = details;
    }
    
    // Getter and Setter methods
    public String getSubject(){
        return subject;
    }
    
    public void setSubject(String subject){
        this.subject = subject;
    }
    
    public String getDetails(){
        return details;
    }
    
    public void setDetails(String details) {
        this.details = details;
    }
}
