package framework;

public enum Gender {
    FEMALE("f"),
    MALE("m");

    public String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

}
