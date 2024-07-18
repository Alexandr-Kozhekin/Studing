package Queue;

public class Command {

    private String com;

    public Command(String com) {
        this.com = com;
    }

    public void operations() {
        System.out.println("I say " + com);
    }

    @Override
    public String toString() {
        return "Command{" +
                "com='" + com + '\'' +
                '}';
    }
}
