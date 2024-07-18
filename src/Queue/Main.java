package Queue;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

//        Command command = new Command("command one");
//        Command command2 = new Command("command two");
//        Command command3 = new Command("command three");
//        Command command4 = new Command("command four");
//        Command command5 = new Command("command five");
//
//        CommandManager commandManager = new CommandManager();
//        commandManager.addCommands(command);
//        commandManager.addCommands(command2);
//        commandManager.addCommands(command3);
//        commandManager.addCommands(command4);
//        commandManager.addCommands(command5);
//
//        for(Command x : commandManager.getCommands())
//            x.operations();

        PriorityQueue<Another> priorityE = new PriorityQueue<>();

        Another another = new Another();
        Another another1 = new Another();
        Another another2 = new Another();

        priorityE.offer(another1);
        priorityE.offer(another);
        priorityE.offer(another2);

        System.out.println(priorityE);

//        PriorityQueue<Double> priorityQ = new PriorityQueue<>();
//        Random random = new Random(47);
//
//        for(int i = 0; i < 5; i++)
//            priorityQ.offer(random.nextDouble());
//
//        System.out.println(priorityQ);
    }

}
