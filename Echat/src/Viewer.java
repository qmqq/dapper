import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

//swing控件GUI
class Viewer {
    JLabel imageLabel;
    private Controller controller;
    private JTextField ipAddress;
    private JTextArea messageText;
    private JTextArea receiveMessageText;
    private JFrame frame;

    Viewer() {

        controller = new Controller(this);

        //panel setting
        frame = new JFrame("Uchat@Sigmod");
        frame.setLayout(null);
        frame.setSize(500, 540);
        frame.setResizable(false);
        frame.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width) / 2)-200,
                ((Toolkit.getDefaultToolkit().getScreenSize().height) / 2) -200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //background setting
        ImageIcon img = new ImageIcon("src/images/back.jpg");
        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        JPanel imagePanel = (JPanel) frame.getContentPane();
        frame.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
        imagePanel.setOpaque(false);

        //address input area
        JLabel ipAddress1 = new JLabel("Receiver:");
        ipAddress1.setForeground(Color.LIGHT_GRAY);
        ipAddress1.setBackground(Color.LIGHT_GRAY);
        ipAddress1.setBounds(25, 360, 300, 25);
        ipAddress = new JTextField("");
        ipAddress.setBounds(100, 360, 275, 25);

        //display message area
        Font font1 = new Font("Century Gothic", Font.PLAIN, 12);
        receiveMessageText = new JTextArea();
        receiveMessageText.setEditable(false);
        receiveMessageText.setBackground(Color.LIGHT_GRAY);
        JScrollPane scrollPaneReceive = new JScrollPane(receiveMessageText);
        scrollPaneReceive.setBounds(25, 140, 350, 200);

        //button clear function
        JButton clearButton = new JButton("Clear");
        clearButton.setBackground(Color.GRAY);
        clearButton.setForeground(Color.WHITE);
        clearButton.setBorder(new EmptyBorder(0, 0, 0, 0));
        clearButton.setFont(font1);
        clearButton.setBounds(380, 320, 100, 20);
        clearButton.addActionListener(controller);
        clearButton.setActionCommand("Clear");

        //message input area
        JLabel Message = new JLabel("Message:");
        Message.setForeground(Color.LIGHT_GRAY);
        Message.setBackground(Color.LIGHT_GRAY);
        Message.setBounds(25, 388, 300, 30);
        messageText = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(messageText);
        scrollPane.setBounds(25, 420, 350, 60);

        //button send function
        JButton sendButton = new JButton("Send");
        sendButton.setBackground(Color.GRAY);
        sendButton.setForeground(Color.WHITE);
        sendButton.setBorder(new EmptyBorder(0, 0, 0, 0));
        sendButton.setFont(font1);
        sendButton.setBounds(380, 460, 100, 20);
        sendButton.addKeyListener(controller);
        sendButton.addActionListener(controller);
        sendButton.setActionCommand("Send Message");

        //icon under the title
        ImageIcon icon = new ImageIcon("src/images/chat.png");
        imageLabel = new JLabel(icon);
        imageLabel.setBounds(200, 30, icon.getIconWidth(), icon.getIconHeight());

        //combine the component
        frame.add(scrollPane);
        frame.add(sendButton);
        frame.add(clearButton);
        frame.add(scrollPaneReceive);
        frame.add(imageLabel);
        frame.add(ipAddress1);
        frame.add(ipAddress);
        frame.add(Message);
        frame.setVisible(true);


    }


    String getIpAddress() {
        return ipAddress.getText();

    }

    String getMessage() {
        return messageText.getText();
    }

    void received(String value) {
        String text = receiveMessageText.getText();
        text = text + value + "\n";
        receiveMessageText.setText(text);
    }

    void clear() {
        receiveMessageText.setText("");
    }

    void messageTextClear() {
        messageText.setText("");
    }

}