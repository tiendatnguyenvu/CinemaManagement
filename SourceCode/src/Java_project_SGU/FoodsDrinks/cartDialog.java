package Java_project_SGU.FoodsDrinks;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class cartDialog extends javax.swing.JDialog {
    private int id;
    private list_cart cart_list;
    public cartDialog() {
        this.id=0;
        this.cart_list=new list_cart();
        initComponents();
        solveEvents();
    }
    
    public void solveEvents() {
        this.cart_table.setEnabled(false);
        
        this.order.addActionListener(new ActionListener(){ 
            @Override
            public void actionPerformed(ActionEvent e){
                //add vao bill
                SwingUtilities.windowForComponent(order).dispose();
            }
        });
        
        this.clear.addActionListener(new ActionListener(){ 
            @Override
            public void actionPerformed(ActionEvent e){
                cart_list.clearCart();
                JOptionPane.showMessageDialog(rootPane, "Đã làm mới giỏ hàng");
                SwingUtilities.windowForComponent(clear).dispose();
            }
        });
//        
//        this.cart_table.addMouseListener(new MouseAdapter(){
//            @Override
//            public void mouseClicked(MouseEvent m){
//                get_set_FnD fnd = new get_set_FnD();
//                //lay dong va cot theo vi tri chuot
//                int row = cart_table.rowAtPoint(m.getPoint());
//                int col = cart_table.columnAtPoint(m.getPoint());
//                if(col==4){
//                    fnd.delete_detail(cart_table.getValueAt(row, 0).toString());
//                    JOptionPane.showMessageDialog(rootPane, "Đã xóa "+cart_table.getValueAt(row, 0).toString());
//                }
//            }
//        });
    }
    
    public void set_table(Object[] data){
        DefaultTableModel model = (DefaultTableModel) this.cart_table.getModel();
        model.addRow(data);
        this.cart_table.updateUI();
    }
    
    public void set_id(int ID){
        this.id = ID;
    }
    
    public void set_total(int value){
        this.total.setText("Tổng tiền: "+value);
    }
        
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll_cart = new javax.swing.JScrollPane();
        cart_table = new javax.swing.JTable();
        order = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        total = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Giỏ Hàng");
        setResizable(false);
        setSize(new java.awt.Dimension(500, 500));

        scroll_cart.setHorizontalScrollBar(null);
        scroll_cart.setPreferredSize(new java.awt.Dimension(500, 400));

        cart_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Tên sản phẩm", "Size", "Số lượng", "Thành tiền"
            }
        ));
        scroll_cart.setViewportView(cart_table);

        order.setText("Mua");

        clear.setText("Xóa hết");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        title.setText("Danh sách món đã đặt:");

        total.setText("Tổng tiền:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(scroll_cart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(title)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(total)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(clear)
                                .addGap(18, 18, 18)
                                .addComponent(order)))
                        .addGap(36, 36, 36))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(title)
                .addGap(2, 2, 2)
                .addComponent(scroll_cart, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(total)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clear)
                    .addComponent(order))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable cart_table;
    private javax.swing.JButton clear;
    private javax.swing.JButton order;
    private javax.swing.JScrollPane scroll_cart;
    private javax.swing.JLabel title;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
