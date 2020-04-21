package requestresponseclasses;

public class RequestClass {
    String firstName;
    String lastName;
    String id;

    //String httpMthod;
    //String currentPath ;

    //http://localhost/api/dvds  // return all devds

    ///api/devds/{id}

    //if(curret){
    //    return GET_ALLDEVDs;
   // }
    public RequestClass() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public RequestClass(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
