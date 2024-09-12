package spring.learn.model;

public class UserModel {
    private String firstName;
    private String lastName;
    private Integer membershipId;

    public UserModel(String firstName, String lastName, Integer membershipId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.membershipId = membershipId;
    }

    public UserModel() {}

    @Override
    public String toString() {
        return super.toString();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getMembershipId() {
        return membershipId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMembershipId(Integer membershipId) {
        this.membershipId = membershipId;
    }
}
