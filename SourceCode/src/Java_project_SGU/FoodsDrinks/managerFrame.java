package Java_project_SGU.FoodsDrinks;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class managerFrame extends javax.swing.JFrame{
    private list_food data_list;
    private ArrayList<JPanel> panelList;
    private addDialog add;
    
    public managerFrame() {
        this.data_list = new list_food();
        this.panelList = new ArrayList<>();
        this.add=new addDialog();
        initComponents();
        showPanels();
        solveEvents();
    }
    
    public void solveEvents(){
        this.add_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add.setVisible(true);
            }
        });
        
        this.filter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPanels();
            }
        });
        
        this.search_bar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu_panel.removeAll();
                menu_panel.setLayout(new FlowLayout());
                createPanels("mSearch", search_bar.getText());
                if(!panelList.isEmpty()){
                    if (panelList.size()%5 ==0 ){
                        menu_panel.setPreferredSize(new Dimension(menu_panel.getPreferredSize().width, 250*(panelList.size()/5)+20));
                    }
                    else{
                        menu_panel.setPreferredSize(new Dimension(menu_panel.getPreferredSize().width, 250*(panelList.size()/5+1)+20));
                    }
                    for(JPanel i : panelList){
                        i.setPreferredSize(new Dimension(200,250));
                        menu_panel.add(i);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "hiện chưa có sản phẩm nào tên "+search_bar.getText());
                    filter.setSelectedIndex(0);
                }
                menu_panel.repaint();
                menu_panel.revalidate();
            }
        });
    }
    
    public void createPanels(String getfor, String value){
        this.panelList.clear();
        this.data_list.setList(getfor, value);
        for(Food i : this.data_list.getList()){
            try{
                JPanel box = new JPanel();
                box.setSize(200, 250);
                box.setLayout(null);
                box.setBackground(Color.WHITE);
                String ID = i.getID();
                ImageIcon icon = new ImageIcon(ImageIO.read(new File(i.getImg())).getScaledInstance(180,150, Image.SCALE_SMOOTH));
                JLabel image = new JLabel(icon);
                JLabel item_name = new JLabel("Tên: "+i.getName());
                JLabel item_type = new JLabel("Loại: "+i.getType());
                JLabel item_price = new JLabel("Giá: "+i.getPrice());
                JLabel item_status = new JLabel("Đang bán: ");
                JComboBox status = new JComboBox(new String[] {"có", "không"});
                JButton delete = new JButton("xóa");
                if(i.getSaling()==true){
                    status.setSelectedIndex(0);
                }
                else{
                    status.setSelectedIndex(1);
                }
                status.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            if(status.getSelectedItem().toString().equals("có")){
                                i.setSaling(true);
                            }
                            else {
                                i.setSaling(false);
                            }
                            data_list.setSaling(i);
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                    }
                });
                delete.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                    }
                });
                image.setBounds(10, 5, 180, 150);
                item_name.setBounds(10, 160, item_name.getPreferredSize().width, item_name.getPreferredSize().height);
                item_type.setBounds(10, 180, item_type.getPreferredSize().width, item_type.getPreferredSize().height);
                item_price.setBounds(10, 200, item_price.getPreferredSize().width, item_price.getPreferredSize().height);
                item_status.setBounds(10, 220, 100, item_price.getPreferredSize().height);
                status.setBounds(80, 220,50, 20);
                delete.setBounds(140, 220,50, 20);
                box.add(image);
                box.add(item_name);
                box.add(item_type);
                box.add(item_price);
                box.add(item_status);
                box.add(status);
                box.add(delete);
                this.panelList.add(box);
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
    }
    
    public void showPanels(){
        this.menu_panel.removeAll();
        this.menu_panel.setLayout(new FlowLayout());
        createPanels("manager", this.filter.getSelectedItem().toString());
        if(!this.panelList.isEmpty()){
            if (this.panelList.size()%5 ==0 ){
                this.menu_panel.setPreferredSize(new Dimension(this.menu_panel.getPreferredSize().width, 250*(this.panelList.size()/5)+20));
            }
            else{
                this.menu_panel.setPreferredSize(new Dimension(this.menu_panel.getPreferredSize().width, 250*(this.panelList.size()/5+1)+20));
            }
            for(JPanel i : panelList){
                i.setPreferredSize(new Dimension(200,250));
                this.menu_panel.add(i);
            }
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "hiện chưa có sản phẩm nào thuộc loại "+this.filter.getSelectedItem().toString());
            this.filter.setSelectedIndex(0);
        }
        this.menu_panel.repaint();
        this.menu_panel.revalidate();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        search_bar = new javax.swing.JTextField();
        add_button = new javax.swing.JButton();
        filter = new javax.swing.JComboBox<>();
        scroll_menu = new javax.swing.JScrollPane();
        menu_panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FnD for manager");
        setBackground(new java.awt.Color(255, 0, 153));
        setSize(new java.awt.Dimension(1200, 600));

        search_bar.setText("Tìm kiếm");
        search_bar.setToolTipText("");
        search_bar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_barActionPerformed(evt);
            }
        });

        add_button.setText("Thêm món");

        filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Thức ăn", "Nước", "Combo", "Đang bán", "Đang ẩn"}));

        scroll_menu.setHorizontalScrollBar(null);
        scroll_menu.setPreferredSize(new java.awt.Dimension(1200, 520));
        scroll_menu.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        menu_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
        menu_panel.setBackground(new java.awt.Color(255, 0, 102));
        menu_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        menu_panel.setPreferredSize(new java.awt.Dimension(1200, 520));

        javax.swing.GroupLayout menu_panelLayout = new javax.swing.GroupLayout(menu_panel);
        menu_panel.setLayout(menu_panelLayout);
        menu_panelLayout.setHorizontalGroup(
            menu_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1198, Short.MAX_VALUE)
        );
        menu_panelLayout.setVerticalGroup(
            menu_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 518, Short.MAX_VALUE)
        );

        scroll_menu.setViewportView(menu_panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scroll_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(search_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(add_button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_button, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void search_barActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_barActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_barActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_button;
    private javax.swing.JComboBox<String> filter;
    private javax.swing.JPanel menu_panel;
    private javax.swing.JScrollPane scroll_menu;
    private javax.swing.JTextField search_bar;
    // End of variables declaration//GEN-END:variables
}
