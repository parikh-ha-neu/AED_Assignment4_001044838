/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.Dashboard;

import Health_System.Community;
import Health_System.PersonDirectory;
import Health_System.CommunityDirectory;
import Health_System.Person;
import Health_System.VitalSign;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Harshit
 */
public class HomePage extends javax.swing.JPanel {

    /**
     * Creates new form HomePage
     */
    PersonDirectory personDirectory;
    CommunityDirectory communityDirectory;
    
    public HomePage(JPanel userProcessContainer,PersonDirectory personDirectory, CommunityDirectory communityDirectory) {
        initComponents();
        this.personDirectory = personDirectory;
        this.communityDirectory = communityDirectory;
        
        
        HashSet<String> uniqueCommunities = new HashSet<>();
        for(Person person : personDirectory.getPersonHistory()){
            uniqueCommunities.add(person.getCommunity().getZipCode());
        }
        
        populatePatientsTable(personDirectory, communityDirectory, uniqueCommunities);

        lablePersonTotal.setText(String.valueOf(personDirectory.getPersonHistory().size()));
        
        try {
            lableTotalCommunities.setText(String.valueOf(uniqueCommunities.size()));
        } catch (Exception e) {
            lableTotalCommunities.setText("0");
        }
            
    }
    
    public int getTotalPatientsFromCommunity(String c){
        int count = 0;
        for(Person person: personDirectory.getPersonHistory()){
            Community community = person.getCommunity();
            if(community.getZipCode() == c){
                count++;
            }
        }
        
        return count;
    }
    
    private String VitalSignStatus(int patientAge,int heartRate, int bloodPressure, float weight) {
        String vitalSignStatus = "Normal";
        
        
        
        /*Toddler*/
        if (patientAge >= 1 && patientAge <= 3) {
            if ((heartRate < 80 || heartRate > 130) /*Heart Rate*/
                    || (bloodPressure < 80 || bloodPressure > 110) /*Blood Pressure*/
                    || (weight < 22 || weight > 31)) /*Weight*/ {
                vitalSignStatus = "Abnormal";
            }
        }
        /*Preschooler*/
        if (patientAge >= 4 && patientAge <= 5) {
            if ((heartRate < 80 || heartRate > 120)
                    || (bloodPressure < 80 || bloodPressure > 110)
                    || (weight < 31 || weight > 40)) {
                vitalSignStatus = "Abnormal";
            }
        }
        /*School Age*/
        if (patientAge >= 6 && patientAge <= 12) {
            if ((heartRate < 70 || heartRate > 110)
                    || (bloodPressure < 80 || bloodPressure > 120)
                    || (weight < 41 || weight > 92)) {
                vitalSignStatus = "Abnormal";
            }
        }
        /*Adolescent*/
        if (patientAge >= 13) {
            if ((heartRate < 55 || heartRate > 105)
                    || (bloodPressure < 110 || bloodPressure > 120)
                    || (weight < 110)) {
                vitalSignStatus = "Abnormal";
            }
        }
        return vitalSignStatus;
    }
    
    public int getTotalAbnormalPatientsFromCommunity(String c){
        int count = 0;
        for(Person person: personDirectory.getPersonHistory()){
            int patientAge = person.getAge();
            if(person.getPatient() != null){
       
            for(VitalSign vitalSign : person.getPatient().getVitalSignHistory().getHistory()){
                
                String status = VitalSignStatus(patientAge, vitalSign.getHeartRate(), vitalSign.getBloodPressure(), vitalSign.getWeight());
                if(person.getCommunity().getZipCode() == c && status == "Abnormal"){
                    count++;
                }
            }
            
//            System.out.println("vitalSignHistory = " + person.getPatient().getVitalSignHistory().getHistory());
            }  
        }
        return count;
    }
    
    private void populatePatientsTable(PersonDirectory personDirectory, CommunityDirectory communityDirectory, HashSet<String> uniqueCommunities ) {
        DefaultTableModel model = (DefaultTableModel) tableDashboard.getModel();
        model.setRowCount(0);
        if(personDirectory.getPersonHistory().isEmpty())
        {
            return;
        }
        for (String c: uniqueCommunities) {
            Object[] row = new Object[3];
            row[0] = c;
            row[1] = getTotalPatientsFromCommunity(c);
            row[2] = getTotalAbnormalPatientsFromCommunity(c);            
            model.addRow(row);
        }
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lablePerson = new javax.swing.JLabel();
        lablePersonTotal = new javax.swing.JLabel();
        lableCommunity = new javax.swing.JLabel();
        lableTotalCommunities = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDashboard = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(60, 86, 112));

        jPanel1.setBackground(new java.awt.Color(60, 86, 112));

        lablePerson.setForeground(new java.awt.Color(255, 255, 255));
        lablePerson.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lablePerson.setText("Total Person:");

        lablePersonTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lablePersonTotal.setForeground(new java.awt.Color(255, 255, 255));
        lablePersonTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lableCommunity.setForeground(new java.awt.Color(255, 255, 255));
        lableCommunity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lableCommunity.setText("Total Communities:");

        lableTotalCommunities.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lableTotalCommunities.setForeground(new java.awt.Color(255, 255, 255));
        lableTotalCommunities.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        tableDashboard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Community", "Total Patients", "Total Abnormal patients"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableDashboard);

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Dashboard");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lablePerson, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lablePersonTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(346, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lableCommunity, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lableTotalCommunities, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lablePerson, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lablePersonTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lableCommunity, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lableTotalCommunities, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(193, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lableCommunity;
    private javax.swing.JLabel lablePerson;
    private javax.swing.JLabel lablePersonTotal;
    private javax.swing.JLabel lableTotalCommunities;
    private javax.swing.JTable tableDashboard;
    // End of variables declaration//GEN-END:variables
}
