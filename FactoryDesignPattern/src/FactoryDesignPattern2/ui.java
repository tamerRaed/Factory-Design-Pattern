package FactoryDesignPattern2;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SpinnerListModel;

public class ui extends javax.swing.JFrame {

    ArrayList<Employee> employees=Employee.employees;
    String value;
    String keySearch;
    public ui() {
        initComponents();
        ArrayList<String> arrayList=new ArrayList<>();
        for(int i: FeildsFactory.m.keySet()){
            String name=FeildsFactory.m.get(i).getSimpleName();
            arrayList.add(name);
        }
        
        SpinnerListModel model = new SpinnerListModel(arrayList);
        jSpinner.setModel(model);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tf_query = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        jSpinner = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tf_query.setText("Search Query");

        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        jLabel1.setText("Results:");

        jTextArea.setColumns(20);
        jTextArea.setRows(5);
        jScrollPane1.setViewportView(jTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_search))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tf_query, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addComponent(jSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_query, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(btn_search)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        //this code will be simple if i convert the search in arrayList to search in a database :)
        keySearch=(String) jSpinner.getValue();
        value = tf_query.getText();
        for (int i = 0; i < employees.size(); i++) {
            if (keySearch.equals("id")) {
                if (!(value.matches("[0-9]*"))) {
                    JOptionPane.showMessageDialog(
                            this, "Id Must Be Numric Digits",
                            "Invalid Data Type",
                            JOptionPane.ERROR_MESSAGE);
                    break;
                } else {
                    if (employees.get(i).getId() == Integer.valueOf(value)) {
                        jTextArea.setText("Item "+i);
                        break;
                    } else {
                        if (i == employees.size() - 1) {
                            JOptionPane.showMessageDialog(
                                    this, "Not Found!",
                                    "Search Failed",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
            }
            if (keySearch.equals("name")) {
                if (employees.get(i).getName().equalsIgnoreCase(value)) {
                    jTextArea.setText("Item "+i);
                    break;
                } else {
                    if (i == employees.size() - 1) {
                        JOptionPane.showMessageDialog(
                                this, "Not Found!",
                                "Search Failed",
                                JOptionPane.WARNING_MESSAGE);
                    }

                }
            }
        }
    }//GEN-LAST:event_btn_searchActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner;
    private javax.swing.JTextArea jTextArea;
    private javax.swing.JTextField tf_query;
    // End of variables declaration//GEN-END:variables
}
