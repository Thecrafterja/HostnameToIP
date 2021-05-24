public class CMDArgument {

    private String type;
    private String data;

    public CMDArgument(String type, String data) {
        this.type = type;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "CMDArgument{" +
                "type='" + type + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
