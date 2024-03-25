import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingDoiSoNhiPhan extends JFrame {

    private JTextField ThapPhanField;
    private JTextField NhiPhanField;

    public SwingDoiSoNhiPhan() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Sang\\Downloads\\188987.png"));
        setTitle("Đổi số nhị phân 8 bit có dấu");
        setSize(350, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel ThapPhanLabel = new JLabel("Thập phân:");
        JLabel NhiPhanLabel = new JLabel("Nhị phân:");

        ThapPhanField = new JTextField(10);
        NhiPhanField = new JTextField(10);
        NhiPhanField.setEditable(false);

        JButton convertButton = new JButton("Đổi");
        JButton clearButton = new JButton("Xóa");

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int decimal = Integer.parseInt(ThapPhanField.getText());
                    if (decimal >= -Math.pow(2, 7) && decimal <= Math.pow(2, 7) - 1) {
                        String NhiPhan = convertToSignedBinary(decimal);
                        NhiPhanField.setText(NhiPhan);
                    } else {
                        JOptionPane.showMessageDialog(null, "Không thể đổi số này vui lòng nhập lại", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng giá trị là số!!!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ThapPhanField.setText("");
                NhiPhanField.setText("");
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(convertButton);
        buttonPanel.add(clearButton);

        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(ThapPhanLabel);
        inputPanel.add(ThapPhanField);
        inputPanel.add(NhiPhanLabel);
        inputPanel.add(NhiPhanField);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().add(mainPanel);
    }

    private String convertToSignedBinary(int decimal) {
        // Chuyển đổi số thập phân thành số nhị phân
        String binary = Integer.toBinaryString(Math.abs(decimal));

        // Thêm các số 0 vào đầu chuỗi để có 8 bit
        binary = String.format("%8s", binary).replace(' ', '0');

        // Nếu số thập phân âm, thực hiện phép đảo bit và cộng 1
        if (decimal < 0) {
            StringBuilder invertedBinary = new StringBuilder();
            for (char c : binary.toCharArray()) {
                invertedBinary.append(c == '0' ? '1' : '0');
            }
            binary = invertedBinary.toString();
            int carry = 1;
            StringBuilder result = new StringBuilder();
            for (int i = binary.length() - 1; i >= 0; i--) {
                int sum = (binary.charAt(i) - '0') + carry;
                result.insert(0, sum % 2);
                carry = sum / 2;
            }
            binary = result.toString();
        }

        return binary;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingDoiSoNhiPhan().setVisible(true);
            }
        });
    }
}
