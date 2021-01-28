package apps.swing;

import control.Command;
import control.DownCommand;
import control.LeftCommand;
import control.RightCommand;
import control.UpCommand;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import model.Block;
import view.BlockDisplay;

/**
 *
 * @author david
 */
public class Main extends JFrame{
    
    public static void main(String[] args) {
        new Main().execute();
        
    }
    private BlockDisplay blockDisplay;
    private Map<String, Command> commands = new HashMap<>();
    
    public Main() {
        this.setTitle("Block shifter");
        this.setSize(700, 762);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().add(blockPanel());
        this.add(toolbar(), BorderLayout.SOUTH);
        
        Block block = new Block(4,4);
        this.blockDisplay.display(block);
        this.commands.put("left", new LeftCommand(block));
        this.commands.put("up", new UpCommand(block));
        this.commands.put("down", new DownCommand(block));
        this.commands.put("right", new RightCommand(block));
    }
    
    
    
    private void execute() {
        this.setVisible(true);
    }

    private JPanel blockPanel() {
        BlockPanel blockPanel = new BlockPanel();
        this.blockDisplay = blockPanel;
        return blockPanel;
    }

    private JMenuBar toolbar() {
        JMenuBar menu = new JMenuBar();
        menu.add(button("left"));
        menu.add(button("up"));
        menu.add(button("down"));
        menu.add(button("right"));
        return menu;
    }

    private JButton button(String name) {
        JButton button = new JButton(name);
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get(name).execute();
            }
            
        });
        return button;
    }
}
