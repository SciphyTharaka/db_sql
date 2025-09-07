public class Record {
    private int code;
    private String fullName;
    private int years;
    private String mail;

    public Record(int code, String fullName, int years, String mail) {
        this.code = code;
        this.fullName = fullName;
        this.years = years;
        this.mail = mail;
    }

    public int getCode() { return code; }
    public String getFullName() { return fullName; }
    public int getYears() { return years; }
    public String getMail() { return mail; }

    public void setCode(int code) { this.code = code; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setYears(int years) { this.years = years; }
    public void setMail(String mail) { this.mail = mail; }

    @Override
    public String toString() {
        return code + " | " + fullName + " | " + years + " | " + mail;
    }
}
