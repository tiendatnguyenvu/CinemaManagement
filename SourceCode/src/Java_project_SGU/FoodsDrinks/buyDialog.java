package Java_project_SGU.FoodsDrinks;
import java.awt.event.*;
import javax.swing.*;

public class buyDialog extends javax.swing.JDialog { 
    private list_cart cart_list;
    private String id;
    private cart cart;
    public buyDialog() {
        this.cart_list=new list_cart();
        this.id=null;
        this.cart=new cart();
        initComponents();
    }
    
    public void solveEvents(){
        this.quantity.setText("1");
        this.add.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                setCart(cart_list.getCart(get_quantity(), get_size(), id));
                if(cart_list.addList(cart)==true){
                    JOptionPane.showMessageDialog(rootPane,"Đã thêm vào giỏ hàng");
                    SwingUtilities.windowForComponent(add).dispose();
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Số lượng phải là một số nguyên dương");
                }
            }
        });
        
        this.cancel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                SwingUtilities.windowForComponent(cancel).dispose();
            }
        });
    }
    
    public void set_infor(Food i){
        JLabel Name = new JLabel(i.getName());
        JLabel Type = new JLabel(i.getType());
        JLabel Price = new JLabel(Integer.toString(i.getPrice()));
        Name.setBounds(this.size.getBounds().x, this.tensp.getBounds().y, Name.getPreferredSize().width, Name.getPreferredSize().height);
        Type.setBounds(this.size.getBounds().x, this.loai.getBounds().y, Type.getPreferredSize().width, Type.getPreferredSize().height);
        Price.setBounds(this.size.getBounds().x, this.dongia.getBounds().y, Price.getPreferredSize().width, Price.getPreferredSize().height);
    
        this.add(Name);
        this.add(Type);
        this.add(Price);
    }
    
    public void setID(String ID){
        this.id=ID;
    }
    
    public int get_quantity(){
        return Integer.parseInt(this.quantity.getText());
    }
    
    public String get_size(){
        return this.size.getSelectedItem().toString();
    }
    
    public void setCart(cart i){
        this.cart=i;
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

        tensp = new javax.swing.JLabel();
        dongia = new javax.swing.JLabel();
        dolon = new javax.swing.JLabel();
        soluong = new javax.swing.JLabel();
        size = new javax.swing.JComboBox<>();
        quantity = new javax.swing.JTextField();
        cancel = new javax.swing.JButton();
        add = new javax.swing.JButton();
        loai = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thêm vào giỏ");

        tensp.setText("Tên Sản Phẩm: ");

        dongia.setText("Đơn Giá:");

        dolon.setText("Size:");

        soluong.setText("Số Lượng:");

        size.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "M", "L", "XL" }));
        size.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizeActionPerformed(evt);
            }
        });

        cancel.setText("Hủy");

        add.setText("Thêm");

        loai.setText("Loại:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(220, Short.MAX_VALUE)
                .addComponent(cancel)
                .addGap(18, 18, 18)
                .addComponent(add)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(soluong)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(dolon)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                            .addComponent(size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(quantity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dongia)
                                .addComponent(loai)
                                .addComponent(tensp))
                            .addGap(0, 0, Short.MAX_VALUE))))
                .addContainerGap(214, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(tensp)
                .addGap(18, 18, 18)
                .addComponent(loai)
                .addGap(18, 18, 18)
                .addComponent(dongia)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dolon)
                    .addComponent(size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(soluong)
                    .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel)
                    .addComponent(add))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void sizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sizeActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel dolon;
    private javax.swing.JLabel dongia;
    private javax.swing.JLabel loai;
    private javax.swing.JTextField quantity;
    private javax.swing.JComboBox<String> size;
    private javax.swing.JLabel soluong;
    private javax.swing.JLabel tensp;
    // End of variables declaration//GEN-END:variables
}
