
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;

/**
 *
 * @author 96emisun
 */
public class RegGUI extends javax.swing.JFrame {
    
    private final Library lib;
    private String filename;
    private ArrayList<AbstractItem> info;
    
    /**
     * Creates new form RegGUI
     */
    public RegGUI() {
        initComponents();
        lib = new Library();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroup = new javax.swing.ButtonGroup();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        pnlTab1 = new javax.swing.JPanel();
        rbtnMovie = new javax.swing.JRadioButton();
        rbtnMusic = new javax.swing.JRadioButton();
        rbtnGame = new javax.swing.JRadioButton();
        lblName = new javax.swing.JLabel();
        lblGenre = new javax.swing.JLabel();
        lblYear = new javax.swing.JLabel();
        txfName = new javax.swing.JTextField();
        txfGenre = new javax.swing.JTextField();
        txfYear = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaPrint1 = new javax.swing.JTextArea();
        btnChooseFile = new javax.swing.JButton();
        cobSort = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        txfSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        chbSaveDamaged = new javax.swing.JCheckBox();
        chbSaveOnLoan = new javax.swing.JCheckBox();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        cobUpdate = new javax.swing.JComboBox();
        chbUpdateDamaged = new javax.swing.JCheckBox();
        chbUpdateOnLoan = new javax.swing.JCheckBox();
        btnUpdate = new javax.swing.JButton();
        pnlTab2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaPrint2 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        txfIMDBTitle = new javax.swing.JTextField();
        btnIMDBSearch = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txfIMDBYear = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuExport = new javax.swing.JMenuItem();
        menuAbout = new javax.swing.JMenuItem();
        menuExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Library_Emil_Sundqvist");

        btnGroup.add(rbtnMovie);
        rbtnMovie.setText("Movie");

        btnGroup.add(rbtnMusic);
        rbtnMusic.setText("Music");

        btnGroup.add(rbtnGame);
        rbtnGame.setText("Game");

        lblName.setText("Name:");

        lblGenre.setText("Genre:");

        lblYear.setText("Year:");

        txaPrint1.setEditable(false);
        txaPrint1.setColumns(20);
        txaPrint1.setRows(5);
        jScrollPane1.setViewportView(txaPrint1);

        btnChooseFile.setText("Choose Library");
        btnChooseFile.setMaximumSize(new java.awt.Dimension(85, 23));
        btnChooseFile.setMinimumSize(new java.awt.Dimension(85, 23));
        btnChooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseFileActionPerformed(evt);
            }
        });

        cobSort.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Default", "Name", "Genre", "Year" }));
        cobSort.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cobSortItemStateChanged(evt);
            }
        });

        jLabel1.setText("Sort the list based on:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Choose the type of object and enter it's information");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Select a CSV/XML file to read from");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Choose how to sort the library");

        jLabel8.setText("Title:");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Use this function to automatically fill in the information");

        jLabel10.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel10.setText("NOTE: This feature only works with movies and games");

        jLabel11.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel11.setText("Default sorting sorts in the order Type->Name->Year->Genre");

        btnDelete.setText("Delete");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdd.setText("Save");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel13.setText("Only CSV files can be deleted from or updated ");

        chbSaveDamaged.setText("Damaged");

        chbSaveOnLoan.setText("On loan");

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Update the status of a saved item or delete it");

        cobUpdate.setEnabled(false);
        cobUpdate.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cobUpdateItemStateChanged(evt);
            }
        });

        chbUpdateDamaged.setText("Damaged");
        chbUpdateDamaged.setEnabled(false);

        chbUpdateOnLoan.setText("On loan");
        chbUpdateOnLoan.setEnabled(false);

        btnUpdate.setText("Update");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTab1Layout = new javax.swing.GroupLayout(pnlTab1);
        pnlTab1.setLayout(pnlTab1Layout);
        pnlTab1Layout.setHorizontalGroup(
            pnlTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTab1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTab1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1)
                    .addGroup(pnlTab1Layout.createSequentialGroup()
                        .addGroup(pnlTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3)
                                .addComponent(btnChooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10)
                                .addGroup(pnlTab1Layout.createSequentialGroup()
                                    .addGroup(pnlTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rbtnMusic)
                                        .addComponent(rbtnGame)
                                        .addComponent(rbtnMovie))
                                    .addGap(16, 16, 16)
                                    .addGroup(pnlTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblYear)
                                        .addComponent(lblName)
                                        .addComponent(lblGenre))
                                    .addGap(18, 18, 18)
                                    .addGroup(pnlTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txfName)
                                        .addComponent(txfGenre)
                                        .addComponent(txfYear, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jLabel2)
                                .addGroup(pnlTab1Layout.createSequentialGroup()
                                    .addComponent(chbSaveDamaged)
                                    .addGap(18, 18, 18)
                                    .addComponent(chbSaveOnLoan))
                                .addComponent(jSeparator4)
                                .addComponent(jLabel14)
                                .addComponent(btnAdd)
                                .addComponent(chbUpdateDamaged)
                                .addComponent(chbUpdateOnLoan)
                                .addGroup(pnlTab1Layout.createSequentialGroup()
                                    .addComponent(btnUpdate)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnDelete))
                                .addComponent(cobUpdate, 0, 330, Short.MAX_VALUE))
                            .addComponent(jLabel13))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(cobSort, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(10, 10, 10))
        );
        pnlTab1Layout.setVerticalGroup(
            pnlTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTab1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTab1Layout.createSequentialGroup()
                        .addGroup(pnlTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnlTab1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnChooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel9))
                            .addGroup(pnlTab1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cobSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(pnlTab1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(7, 7, 7)
                                .addGroup(pnlTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSearch)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rbtnMovie)
                                    .addComponent(lblName)
                                    .addComponent(txfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rbtnMusic)
                                    .addComponent(lblGenre)
                                    .addComponent(txfGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(pnlTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rbtnGame)
                                    .addComponent(lblYear)
                                    .addComponent(txfYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chbSaveOnLoan)
                                    .addComponent(chbSaveDamaged, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAdd)
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(cobUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(chbUpdateDamaged)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chbUpdateOnLoan)
                                .addGap(11, 11, 11)
                                .addGroup(pnlTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnUpdate)
                                    .addComponent(btnDelete))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE))))
                    .addComponent(jSeparator5))
                .addContainerGap())
        );

        jTabbedPane3.addTab("Library", pnlTab1);

        txaPrint2.setColumns(20);
        txaPrint2.setLineWrap(true);
        txaPrint2.setRows(5);
        jScrollPane2.setViewportView(txaPrint2);

        jLabel6.setText("Enter the title of a movie or game:");

        btnIMDBSearch.setText("Search");
        btnIMDBSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIMDBSearchActionPerformed(evt);
            }
        });

        jLabel7.setText("Enter the release year of the movie/game:");

        javax.swing.GroupLayout pnlTab2Layout = new javax.swing.GroupLayout(pnlTab2);
        pnlTab2.setLayout(pnlTab2Layout);
        pnlTab2Layout.setHorizontalGroup(
            pnlTab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTab2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(btnIMDBSearch)
                    .addComponent(txfIMDBTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txfIMDBYear, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlTab2Layout.setVerticalGroup(
            pnlTab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTab2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTab2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfIMDBTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfIMDBYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnIMDBSearch)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane3.addTab("Get info from IMDB", pnlTab2);

        jMenu1.setText("Options");

        menuExport.setText("Export As XML");
        menuExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExportActionPerformed(evt);
            }
        });
        jMenu1.add(menuExport);

        menuAbout.setText("About");
        menuAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAboutActionPerformed(evt);
            }
        });
        jMenu1.add(menuAbout);

        menuExit.setText("Exit Program");
        menuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExitActionPerformed(evt);
            }
        });
        jMenu1.add(menuExit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
        Selects which file to write to / read from
    */
    private void btnChooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseFileActionPerformed
        filename = lib.chooseFile();
        read();
    }//GEN-LAST:event_btnChooseFileActionPerformed

    /*
        Sends a request to the IMDB API and displays the result in a textarea
    */
    private void btnIMDBSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIMDBSearchActionPerformed
        txaPrint2.setText("");
        
        try{
            
            String title = txfIMDBTitle.getText();
            String year = txfIMDBYear.getText();
            
            String xml = lib.getXMLString(title, year);
            
            ArrayList<String[]> arrays = lib.readFromIMDB(xml);
            
            for(int i = 0; i<19; i++){
                txaPrint2.append(
                arrays.get(0)[i] + ": " + arrays.get(1)[i] + "\n\n");
            }
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Something went wrong");
        }
    }//GEN-LAST:event_btnIMDBSearchActionPerformed

    /*
        Sends a request to the IMDB API and displays certain attributes in text fields
    */
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try{
            
            String title = txfSearch.getText();
            
            String xml = lib.getXMLString(title, null);
            
            ArrayList<String[]> arrays = lib.readFromIMDB(xml);
            
            txfName.setText(arrays.get(1)[11]);
            txfGenre.setText(arrays.get(1)[0]);
            txfYear.setText(arrays.get(1)[9].substring(arrays.get(1)[9].length() - 4));
            
            // Selects the type of the item
            switch (arrays.get(1)[5]) {
                case "movie":
                    {
                        ButtonModel model = rbtnMovie.getModel();
                        btnGroup.setSelected(model, true);
                        break;
                    }
                case "game":
                    {
                        ButtonModel model = rbtnGame.getModel();
                        btnGroup.setSelected(model, true);
                        break;
                    }
            }
            
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Something went wrong");
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    /*
        Deletes an item from the selected file
    */
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String itemName = String.valueOf(cobUpdate.getSelectedItem());
        try {
            lib.deleteItem(itemName, info);
        } catch (IOException ex) {}
        read();
    }//GEN-LAST:event_btnDeleteActionPerformed

    /*
        Adds an item to the selected CSV file
    */
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String format = lib.getFormat(filename);
        AbstractItem item = null;
        
        String damaged;
        String onLoan;
        
        if(chbSaveDamaged.isSelected() == true){
            damaged = "1";
        } else{
            damaged = "0";
        }
        
        if(chbSaveOnLoan.isSelected() == true){
            onLoan = "1";
        } else{
            onLoan = "0";
        }
        
        // If the file is a CSv file, check if it exists. If it doesn't, create a new file
        if("csv".equals(format)){
            lib.checkFileExistence(filename);
        }
        
        // Create a new item depending on the selected type
        if(rbtnMovie.isSelected()){
            item = new Movie(txfName.getText(), txfGenre.getText(), txfYear.getText(), damaged, onLoan, null);
        } else if(rbtnMusic.isSelected()){
            item = new Music(txfName.getText(), txfGenre.getText(), txfYear.getText(), damaged, onLoan, null);
        } else if(rbtnGame.isSelected()){
            item = new Game(txfName.getText(), txfGenre.getText(), txfYear.getText(), damaged, onLoan, null);
        }
        
        // Save the file
        if("csv".equals(format)){
            if(lib.writeToCSV(format, item)){
                txfName.setText("");
                txfGenre.setText("");
                txfYear.setText("");
                txfSearch.setText("");
                chbSaveDamaged.setSelected(false);
                chbSaveOnLoan.setSelected(false);
                read();
            }
        } else{
            JOptionPane.showMessageDialog(null, "You have to select a CSV file");
        }
        btnGroup.clearSelection();
    }//GEN-LAST:event_btnAddActionPerformed

    /*
        Whenever a new sorting option is selected, update the textarea
    */
    private void cobSortItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cobSortItemStateChanged
        read();
    }//GEN-LAST:event_cobSortItemStateChanged

    /*
        Updates the Damaged / On Loan status of the item
    */
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String itemName = String.valueOf(cobUpdate.getSelectedItem());

        String damaged;
        String onLoan;

        if(chbUpdateDamaged.isSelected() == true){
            damaged = "1";
        } else{
            damaged = "0";
        }

        if(chbUpdateOnLoan.isSelected() == true){
            onLoan = "1";
        } else{
            onLoan = "0";
        }

        try {
            lib.updateItem(itemName, info, damaged, onLoan);
        } catch (IOException ex) {}

        chbUpdateDamaged.setSelected(false);
        chbUpdateOnLoan.setSelected(false);
        read();
    }//GEN-LAST:event_btnUpdateActionPerformed

    /*
        Check or uncheck the checkboxes depending on what item is selected in
        the JComboBox
    */
    private void cobUpdateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cobUpdateItemStateChanged
        String format = lib.getFormat(filename);
        String sorting = String.valueOf(cobSort.getSelectedItem());
        String itemName = String.valueOf(cobUpdate.getSelectedItem());

        ArrayList<AbstractItem> data = lib.read(sorting, format);

        for(AbstractItem abItem : data){
            if(abItem.getName().equals(itemName)){

                if("1".equals(abItem.getDamaged())){
                    chbUpdateDamaged.setSelected(true);
                } else{
                    chbUpdateDamaged.setSelected(false);
                }

                if("1".equals(abItem.getOnLoan())){
                    chbUpdateOnLoan.setSelected(true);
                } else{
                    chbUpdateOnLoan.setSelected(false);
                }

            }
        }
    }//GEN-LAST:event_cobUpdateItemStateChanged

    /*
        Saves the selected CSV file as an XML formatted file
    */
    private void menuExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExportActionPerformed
        ArrayList<AbstractItem> items = lib.read("Name", "csv");
        String file = lib.chooseFile();
        
        lib.export(file, items);
    }//GEN-LAST:event_menuExportActionPerformed

    /*
        Terminates the program
    */
    private void menuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuExitActionPerformed

    /*
        Displays information about the program
    */
    private void menuAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAboutActionPerformed
        JOptionPane.showMessageDialog(null, 
            "This program was created as an assignment " +
            "for the course programming 2.\nIt consists of a library capable of " +
            "reading and writing to/from CSV and XML files.\n\n" +
            "\u00a9 Emil Sundqvist 2015");
    }//GEN-LAST:event_menuAboutActionPerformed
    
    /*
        Updates the textarea by reading from the selected CSV file
    */
    private void read(){
        String format = lib.getFormat(filename);
        String sorting = String.valueOf(cobSort.getSelectedItem());
        
        chbUpdateDamaged.setEnabled(false);
        chbUpdateOnLoan.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        cobUpdate.setEnabled(false);
        cobUpdate.removeAllItems();
        
        if("csv".equals(format)){
            txaPrint1.setText("");
            
            // Reads from the selected file and returns the items
            info = lib.read(sorting, format);
            String[] headlines = null;

            try {
                headlines = lib.getHeadlines(filename);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Something went wrong"); 
            }
            
            if(info != null){
                for(AbstractItem abItem : info){

                    int damaged = 0;
                    int onLoan = 0;

                    cobUpdate.addItem(abItem.getName());

                    // Prints the data to the textarea
                    txaPrint1.append(
                            headlines[0] + ": " + abItem.getName() + "\n" + 
                            headlines[1] + ": " + abItem.getGenre() + "\n" + 
                            headlines[2] + ": " + abItem.getYear() + "\n" +
                            headlines[3] + ": " + abItem.getType() + "\n" +
                            "Additional information: " + abItem.getStatusString() + "\n\n");

                    chbUpdateDamaged.setEnabled(true);
                    chbUpdateOnLoan.setEnabled(true);
                    btnUpdate.setEnabled(true);
                    btnDelete.setEnabled(true);
                    cobUpdate.setEnabled(true);

                }
            }
            
        } else if("xml".equals(format)){
            txaPrint1.setText("");
            
            // Reads from the selected file and returns the items
            info = lib.read(null, format);
            
            if(info != null){
                for(AbstractItem abItem : info){
                    txaPrint1.append(
                        "Name: " + abItem.getName() + "\n" + 
                        "Genre: " + abItem.getGenre() + "\n" + 
                        "Year: " + abItem.getYear() + "\n" +
                        "Type: " + abItem.getType() + "\n" +
                        "Additional information: " + abItem.getStatusString() + "\n\n");
                }
            }
        }
    }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnChooseFile;
    private javax.swing.JButton btnDelete;
    private javax.swing.ButtonGroup btnGroup;
    private javax.swing.JButton btnIMDBSearch;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JCheckBox chbSaveDamaged;
    private javax.swing.JCheckBox chbSaveOnLoan;
    private javax.swing.JCheckBox chbUpdateDamaged;
    private javax.swing.JCheckBox chbUpdateOnLoan;
    private javax.swing.JComboBox cobSort;
    private javax.swing.JComboBox cobUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JLabel lblGenre;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblYear;
    private javax.swing.JMenuItem menuAbout;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JMenuItem menuExport;
    private javax.swing.JPanel pnlTab1;
    private javax.swing.JPanel pnlTab2;
    private javax.swing.JRadioButton rbtnGame;
    private javax.swing.JRadioButton rbtnMovie;
    private javax.swing.JRadioButton rbtnMusic;
    private javax.swing.JTextArea txaPrint1;
    private javax.swing.JTextArea txaPrint2;
    private javax.swing.JTextField txfGenre;
    private javax.swing.JTextField txfIMDBTitle;
    private javax.swing.JTextField txfIMDBYear;
    private javax.swing.JTextField txfName;
    private javax.swing.JTextField txfSearch;
    private javax.swing.JTextField txfYear;
    // End of variables declaration//GEN-END:variables
}
