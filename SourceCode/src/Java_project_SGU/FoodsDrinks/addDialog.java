package Java_project_SGU.FoodsDrinks;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class addDialog extends javax.swing.JDialog{
    private String url;
    private list_food data_list;
    
    public addDialog() {
        this.url=null;
        this.data_list=new list_food();
        initComponents();
        solveEvents();
    }
    
    public void solveEvents() {
        this.choose_img.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JFileChooser choose = new JFileChooser("C:\\wazapy\\Study\\HK2_nam2\\java\\image");
                choose.setFileFilter(new FileNameExtensionFilter("Images", "jpg", "png"));
                int choosen = choose.showOpenDialog(rootPane);
                if(choosen==JFileChooser.APPROVE_OPTION){
                    url=choose.getSelectedFile().getAbsolutePath();
                    choose_img.setText("chọn lại");
                }
            }
        });
        
        this.save_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(!name.getText().isEmpty()&&!price.getText().isEmpty()&&url != null) {
                    if(isnum(price.getText())==true){
                        if(data_list.addNewFood(kind.getSelectedItem().toString(), name.getText(), status.getSelectedItem().toString(), kind.getSelectedItem().toString(), price.getText(), url)==true){
                            JOptionPane.showMessageDialog(rootPane,"Đã thêm sản phẩm vào hệ thống");
                            SwingUtilities.windowForComponent(save_button).dispose();
                        }
                        else{
                            JOptionPane.showMessageDialog(rootPane, "đã tồn tại trong hệ thống");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(rootPane,"đơn giá phải là một số nguyên dương");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(rootPane, "vui lòng nhập đầy đủ thông tin");
                }
            }
        });
        
        this.cancel_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                SwingUtilities.windowForComponent(cancel_button).dispose();
            }
        });
    }    

    public boolean isnum(String str){
        if(str==null){
            return false;
        }
        try{
            int i = Integer.parseInt(str);
            if(i<=0){
                return false;
            }
        }catch(Exception e){
            return false;
        }
        return true;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cancel_button = new javax.swing.JButton();
        save_button = new javax.swing.JButton();
        kind = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        choose_img = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("thêm món mới");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("add new item"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(300, 300));

        jLabel1.setText("Tên:");

        jLabel3.setText("Giá:");

        jLabel5.setText("Loại");

        cancel_button.setLabel("Cancel");

        save_button.setLabel("Save");

        kind.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thức ăn", "Nước", "Combo"}));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("thông tin của món mới");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setText("Đang bán:");

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"có","không"}));

        jLabel4.setText("Ảnh minh họa:");

        choose_img.setText("Chọn");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kind, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cancel_button, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(save_button, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(choose_img, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(kind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(choose_img))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel_button)
                    .addComponent(save_button))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel_button;
    private javax.swing.JButton choose_img;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox<String> kind;
    private javax.swing.JTextField name;
    private javax.swing.JTextField price;
    private javax.swing.JButton save_button;
    private javax.swing.JComboBox<String> status;
    // End of variables declaration//GEN-END:variables
}
