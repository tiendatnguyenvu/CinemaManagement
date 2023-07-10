package Java_project_SGU.FoodsDrinks;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

public class userFrame extends javax.swing.JFrame {
    private list_food data_list;
    private ArrayList<JPanel> panelList;
    private addDialog add;
    private list_cart cart_list;
    private buyDialog buydl;
    private cartDialog cartdl;
    
    public userFrame() {
        this.data_list = new list_food();
        this.panelList = new ArrayList<>();
        this.add=new addDialog();
        this.cart_list=new list_cart();
        this.buydl=new buyDialog();
        //this.cartdl=new cartDialog();
        initComponents();
        showPanels();
        solveEvents();
    }
    
    public void solveEvents(){
        this.search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.removeAll();
                menu.setLayout(new FlowLayout());
                createPanels("uSearch", search.getText());
                if(!panelList.isEmpty()){
                    if (panelList.size()%5 ==0 ){
                        menu.setPreferredSize(new Dimension(menu.getPreferredSize().width, 250*(panelList.size()/5)+20));
                    }
                    else{
                        menu.setPreferredSize(new Dimension(menu.getPreferredSize().width, 250*(panelList.size()/5+1)+20));
                    }
                    for(JPanel i : panelList){
                        i.setPreferredSize(new Dimension(200,250));
                        menu.add(i);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "hiện chưa có sản phẩm nào thuộc loại "+kind.getSelectedItem().toString());
                    kind.setSelectedIndex(0);
                }
                menu.repaint();
                menu.revalidate();
            }
        });
        
        this.kind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPanels();
            }
        });
        
        this.cart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cartdl.setVisible(true);
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
                JLabel item_price = new JLabel("Đơn giá: "+i.getPrice());
                JButton buy = new JButton("Mua");
                buy.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        buydl.set_infor(i);
                        buydl.setID(ID);
                        buydl.setVisible(true);
                        buydl.solveEvents();
                    }
                });
                image.setBounds(10, 5, 180, 150);
                item_name.setBounds(10, 160, item_name.getPreferredSize().width, item_name.getPreferredSize().height);
                item_type.setBounds(10, 180, item_type.getPreferredSize().width, item_type.getPreferredSize().height);
                item_price.setBounds(10, 200, item_price.getPreferredSize().width, item_price.getPreferredSize().height);
                item_price.setBounds(10, 200, item_price.getPreferredSize().width, item_price.getPreferredSize().height);
                buy.setBounds(120, 220,70, 20);
                box.add(image);
                box.add(item_name);
                box.add(item_type);
                box.add(item_price);
                box.add(buy);
                this.panelList.add(box);
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
    }
    
    public void showPanels(){
        this.menu.removeAll();
        this.menu.setLayout(new FlowLayout());
        createPanels("user", this.kind.getSelectedItem().toString());
        if(!this.panelList.isEmpty()){
            if (this.panelList.size()%5 ==0 ){
                this.menu.setPreferredSize(new Dimension(this.menu.getPreferredSize().width, 250*(this.panelList.size()/5)+20));
            }
            else{
                this.menu.setPreferredSize(new Dimension(this.menu.getPreferredSize().width, 250*(this.panelList.size()/5+1)+20));
            }
            for(JPanel i : panelList){
                i.setPreferredSize(new Dimension(200,250));
                this.menu.add(i);
            }
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "hiện chưa có sản phẩm nào thuộc loại "+this.kind.getSelectedItem().toString());
            this.kind.setSelectedIndex(0);
        }
        this.menu.repaint();
        this.menu.revalidate();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollmenu = new javax.swing.JScrollPane();
        menu = new javax.swing.JPanel();
        kind = new javax.swing.JComboBox<>();
        search = new javax.swing.JTextField();
        cart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Foods and Drinks for user");
        setResizable(false);

        scrollmenu.setHorizontalScrollBar(null);
        scrollmenu.setPreferredSize(new java.awt.Dimension(1200, 520));

        menu.setBackground(new java.awt.Color(255, 0, 102));
        menu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        menu.setPreferredSize(new java.awt.Dimension(1200, 520));

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1198, Short.MAX_VALUE)
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 518, Short.MAX_VALUE)
        );

        scrollmenu.setViewportView(menu);

        kind.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Thức ăn", "Nước", "Combo" }));

        search.setText("Tìm kiếm");
        search.setPreferredSize(new java.awt.Dimension(200, 20));

        cart.setText("giỏ hàng");
        cart.setPreferredSize(new java.awt.Dimension(100, 23));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(kind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(855, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cart;
    private javax.swing.JComboBox<String> kind;
    private javax.swing.JPanel menu;
    private javax.swing.JScrollPane scrollmenu;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
