package Queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class CommandManager {

    private Queue<Command> commands;

    public CommandManager() {
        this.commands = new LinkedList<Command>();
    }

    public void addCommands(Command command) {
        this.commands.offer(command);
        System.out.println(command);
    }

    public Queue<Command> getCommands() {
        return commands;
    }
}
