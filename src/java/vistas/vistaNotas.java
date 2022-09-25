/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Stream;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import rendertabla.renderBotones;
import rendertabla.renderColorCeldas;
import rendertabla.renderMedia;
import ws.ModeloGrado;
import ws.ModeloNota;
import ws.WSColegioIntecap;
import ws.WSColegioIntecap_Service;

/**
 *
 * @author Linda
 */
public class vistaNotas extends javax.swing.JFrame implements MouseListener {
DefaultTableModel mimodelNota;
    ArrayList<ModeloNota> dataNota = new ArrayList<>();
    WSColegioIntecap_Service servicio = new WSColegioIntecap_Service();
    WSColegioIntecap cliente = servicio.getWSColegioIntecapPort();
    
    JButton boton1 = new JButton();
    JButton boton2=new JButton();
    
    
    
    /**
     * Creates new form vistaNotas
     */
    public vistaNotas() {
        initComponents();
        setLocationRelativeTo(null);
        listaAlumnoss();
        tblnotas.addMouseListener(this);
        cargacombobox();
        diseñobotones();
    }
    
    public void diseñobotones(){
        boton2.setText("eliminar");
        boton1.setText("modificar");
        
        boton1.setName("btnmodificar");
        boton2.setName("btneliminar");
        
        boton1.setBackground(Color.PINK);
        boton2.setBackground(Color.CYAN);
        boton1.setForeground(Color.black);
        boton2.setForeground(Color.black);
    }
    public void listaAlumnoss(){
        
        tblnotas.setDefaultRenderer(Object.class, new renderBotones());
        String Titulo[]={"id_alumno","nombre_alumno","id_grado","grado_alumno","nota_1","nota_2","nota_3","nota_4","Media","estado","modificar","eliminar"};
        mimodelNota = new DefaultTableModel(null, Titulo){
            boolean[]estadofilas=new boolean[]{
                    false,false,false,false,false,false,false,false,false,true,false,false
                    };
            public boolean isCellEditable(int rowindex, int columnindex ){
                return estadofilas[columnindex];
            }
            
        };
        
        dataNota = (ArrayList<ModeloNota>) cliente.todosnotas();
        int tamano = cliente.todosnotas().size();
        
        Object[]obj = new Object[12];
        for (int i=0;i<tamano;i++){
            obj[0]=dataNota.get(i).getIdAlumno();
            obj[1]=dataNota.get(i).getNombreAlumno();
            obj[2]=dataNota.get(i).getIdGrado();
            obj[3]=dataNota.get(i).getNombreGrado();
            obj[4]=dataNota.get(i).getNota1();
            obj[5]=dataNota.get(i).getNota2();
            obj[6]=dataNota.get(i).getNota3();
            obj[7]=dataNota.get(i).getNota4();
            
            Double prom=dataNota.get(i).getNota1()+dataNota.get(i).getNota2()+dataNota.get(i).getNota3()+dataNota.get(i).getNota4();
            Double prom2=prom/4;
            
            obj[8]=prom2;
            obj[9]=null;
            obj[10]=boton1;
            obj[11]=boton2;
            
            mimodelNota.addRow(obj);
        }
        
        tblnotas.setModel(mimodelNota);
        agregarcheckbox(9,tblnotas);
        
        //tamaño boton
        tblnotas.setRowHeight(30);
        //poner color a 1 sola columna:
        //tblnotas.getColumnModel().getColumn(4).setCellRenderer(new renderColorCeldas());
        tblnotas.getColumnModel().getColumn(8).setCellRenderer(new renderMedia());
        //colocar color a varias columnas
        for(int i=4;i<=7;i++){
            tblnotas.getColumnModel().getColumn(i).setCellRenderer(new renderColorCeldas());
        }
        
    }
     //accedera a la tabla
  public void vertabla(){
             int numfilas = tblnotas.getColumnCount();
            try{     
       String[] par = new String[numfilas];
       for(int i=0; i<numfilas; i++){
       par [i]= String.valueOf(tblnotas.getValueAt(tblnotas.getSelectedRow(),i));
       }
 
       String idalumno = par[0];
       String idgrado = par[2];
       String nota1 = par[4];
        String nota2 = par[5];
         String nota3 = par[6];
          String nota4 = par[7];
          
              
          txtidalnotas.setText(idalumno);
          txtidgradonotas.setText(idgrado);
          txtnota1.setText(nota1);
          txtnota2.setText(nota2);
          txtnota3.setText(nota3);
          txtnota4.setText(nota4);
       
       


  System.out.println("se esta haciendo click en la tabla");
            }catch(Exception e){
                System.out.println("se elimino la fila");
            }
  }
  public HashMap<String,Integer> listagrados(){
      ArrayList <ModeloGrado> todosgrados = new ArrayList<>();
      
      //creo el hashmap
      HashMap<String,Integer> Objetogradomap = new HashMap<String,Integer>();
      todosgrados = (ArrayList<ModeloGrado>)cliente.todosgrados();
      for(int i =0;i<todosgrados.size();i++){
        ModeloGrado  modgrado = new ModeloGrado();
          modgrado.setIdGrado(todosgrados.get(i).getIdGrado());
          modgrado.setDescripcionGrado(todosgrados.get(i).getDescripcionGrado());
          
          Objetogradomap.put(todosgrados.get(i).getDescripcionGrado(), todosgrados.get(i).getIdGrado());
      }
      return Objetogradomap;
  }
  
  public void cargacombobox(){
      HashMap<String,Integer> Objetogradomapnuevo =listagrados();
      for(String i: Objetogradomapnuevo.keySet()){
          cmbgrado.addItem(i);
      }
  }
public void agregarcheckbox(int columna, JTable mitabla){
   TableColumn tgrado =tblnotas.getColumnModel().getColumn(columna);
   tgrado.setCellEditor(tblnotas.getDefaultEditor(Boolean.class));
   tgrado.setCellRenderer(tblnotas.getDefaultRenderer(Boolean.class));
   
}
public boolean estaseleccionado(int row, int columna, JTable mitabla){
    
    return tblnotas.getValueAt(row, columna)!=null;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblnotas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtidalnotas = new javax.swing.JTextField();
        txtidgradonotas = new javax.swing.JTextField();
        txtnota1 = new javax.swing.JTextField();
        txtnota2 = new javax.swing.JTextField();
        txtnota3 = new javax.swing.JTextField();
        txtnota4 = new javax.swing.JTextField();
        btncrearnota = new javax.swing.JButton();
        btneditarnota = new javax.swing.JButton();
        btneliminarnota = new javax.swing.JButton();
        cmbgrado = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        tblnotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblnotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblnotasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblnotas);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setText("NOTAS");

        jLabel2.setText("ID Alumno:");

        jLabel3.setText("ID Grado:");

        jLabel4.setText("Nota 1:");

        jLabel5.setText("Nota 2:");

        jLabel6.setText("Nota 3:");

        jLabel7.setText("Nota 4:");

        btncrearnota.setText("crear");
        btncrearnota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncrearnotaActionPerformed(evt);
            }
        });

        btneditarnota.setText("editar");
        btneditarnota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarnotaActionPerformed(evt);
            }
        });

        btneliminarnota.setText("eliminar");
        btneliminarnota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarnotaActionPerformed(evt);
            }
        });

        cmbgrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbgradoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtidalnotas, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtidgradonotas, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtnota1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)
                                .addComponent(txtnota2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(131, 131, 131))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)))
                .addGap(30, 30, 30)
                .addComponent(cmbgrado, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(192, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btneliminarnota)
                        .addGap(58, 58, 58)
                        .addComponent(btncrearnota)
                        .addGap(63, 63, 63)
                        .addComponent(btneditarnota))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addComponent(jLabel4)
                            .addGap(304, 304, 304)
                            .addComponent(jLabel6))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(400, 400, 400)
                            .addComponent(txtnota3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(txtnota4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtidalnotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidgradonotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbgrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnota1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnota2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnota3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnota4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncrearnota)
                    .addComponent(btneditarnota)
                    .addComponent(btneliminarnota))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncrearnotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncrearnotaActionPerformed
       if(txtidgradonotas.getText().toString().equals("")||txtidalnotas.getText().toString().equals("")||
               txtnota1.getText().toString().equals("")||txtnota2.getText().toString().equals("")||
               txtnota3.getText().toString().equals("")||txtnota4.getText().toString().equals("")){
           JOptionPane.showMessageDialog(this, "Debe llenar todos los campos para crear");
       }else{
        
        int idgrados= Integer.parseInt(txtidgradonotas.getText().toString());
        int idalumnos = Integer.parseInt(txtidalnotas.getText().toString());
        Double notas1 = Double.parseDouble(txtnota1.getText().toString());
        Double notas2 = Double.parseDouble(txtnota2.getText().toString());
        Double notas3 = Double.parseDouble(txtnota3.getText().toString());
        Double notas4 = Double.parseDouble(txtnota4.getText().toString());
        
        ModeloNota modnota = new ModeloNota();
        modnota.setIdAlumno(idalumnos);
        modnota.setIdGrado(idgrados);
        modnota.setNota1(notas1);
        modnota.setNota2(notas2);
        modnota.setNota3(notas3);
        modnota.setNota4(notas4);
        
        cliente.creaNota(modnota);
        JOptionPane.showMessageDialog(this, "Se ha añadido exitosamente");
        listaAlumnoss();
       }
    }//GEN-LAST:event_btncrearnotaActionPerformed

    private void btneditarnotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarnotaActionPerformed
         if(txtidgradonotas.getText().toString().equals("")||txtidalnotas.getText().toString().equals("")||
               txtnota1.getText().toString().equals("")||txtnota2.getText().toString().equals("")||
               txtnota3.getText().toString().equals("")||txtnota4.getText().toString().equals("")){
           JOptionPane.showMessageDialog(this, "Debe llenar todos los campos para editar");
       }else{
        
        int idgrados= Integer.parseInt(txtidgradonotas.getText().toString());
        int idalumnos = Integer.parseInt(txtidalnotas.getText().toString());
        Double notas1 = Double.parseDouble(txtnota1.getText().toString());
        Double notas2 = Double.parseDouble(txtnota2.getText().toString());
        Double notas3 = Double.parseDouble(txtnota3.getText().toString());
        Double notas4 = Double.parseDouble(txtnota4.getText().toString());
        
        ModeloNota modnota = new ModeloNota();
        modnota.setIdAlumno(idalumnos);
        modnota.setIdGrado(idgrados);
        modnota.setNota1(notas1);
        modnota.setNota2(notas2);
        modnota.setNota3(notas3);
        modnota.setNota4(notas4);
        
        cliente.actualizarNota(modnota);
        JOptionPane.showMessageDialog(this, "Se ha actualizado exitosamente");
        listaAlumnoss();
         }
    }//GEN-LAST:event_btneditarnotaActionPerformed

    private void btneliminarnotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarnotaActionPerformed
        if(txtidgradonotas.getText().toString().equals("")||txtidalnotas.getText().toString().equals("")){
           JOptionPane.showMessageDialog(this, "Debe especificar ID alumno y ID grado");
       }else{
        int idgrados= Integer.parseInt(txtidgradonotas.getText().toString());
        int idalumnos = Integer.parseInt(txtidalnotas.getText().toString());
        
        cliente.eliminarNota(idalumnos, idgrados);
        
        JOptionPane.showMessageDialog(this, "Se ha eliminado exitosamente");
        listaAlumnoss();
        
      
      /////////-------------
      //para eliminar uno por uno
        for(int i=0;i<tblnotas.getRowCount();i++){
           if(estaseleccionado(i,9,tblnotas)){
               System.out.println("se elimino");
             
        
        cliente.eliminarNota(idalumnos, idgrados);
               mimodelNota.removeRow(i);
              
           }
        }
        tblnotas.clearSelection();
        }
       ///---------------
       //para eliminar muchos
      /* int fila=tblnotas.getRowCount();
       for(int j=0; j<fila;j++){
           String posicion = (String)tblnotas.getValueAt(j, 0);
           System.out.println(posicion);
       }*/
     /* int rows = tblnotas.getRowCount();
      
       for(int i=0; i<=tblnotas.getRowCount()+1;i++){
           
        
           while(estaseleccionado(i,8,tblnotas)){
               mimodelNota.removeRow(i);
              int idgrados= Integer.parseInt(txtidgradonotas.getText().toString());
        int idalumnos = Integer.parseInt(txtidalnotas.getText().toString());
        cliente.eliminarNota(idalumnos, idgrados);
           }
            
           
       }
       //mimodelNota.removeRow(i);
           tblnotas.clearSelection();
        
        JOptionPane.showMessageDialog(this, "Se ha eliminado exitosamente");
        listaAlumnoss();*/
        //tblnotas.clearSelection();
     //  int[]rows  = tblnotas.getSelectedRows();
       //con while:
      // while(rows.length>0){
           //mimodelNota.removeRow(tblnotas.convertRowIndexToModel(rows[0]));
           //rows =tblnotas.getSelectedRows();
           
       //}
       //con for
      // for(int i =rows.length;i<=rows.length;i--){
          // mimodelNota.removeRow(tblnotas.convertRowIndexToModel(rows[i]));
           //rows =tblnotas.getSelectedRows();
           
       
      
    }//GEN-LAST:event_btneliminarnotaActionPerformed

    private void cmbgradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbgradoActionPerformed
       String value = (String)cmbgrado.getSelectedItem();
       System.out.println(value);
       
       HashMap<String,Integer> Objetogradomapnuevo =listagrados();
      txtidgradonotas.setText(String.valueOf(Objetogradomapnuevo.get(cmbgrado.getSelectedItem().toString().toString())));
    }//GEN-LAST:event_cmbgradoActionPerformed

    private void tblnotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblnotasMouseClicked
        int columna = tblnotas.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tblnotas.getRowHeight();
        
        if(row<tblnotas.getRowCount()&&row>=0&&columna<tblnotas.getColumnCount()&&columna>=0){
            Object value = tblnotas.getValueAt(row, columna);
            
            if(value instanceof JButton){
                JButton boton = (JButton)value;
                
                if(boton.getName().equals("btnmodificar")){
                    int seleccion=(int)tblnotas.getValueAt(tblnotas.getSelectedRow(), 2);
                    int seleccion2=(int)tblnotas.getValueAt(tblnotas.getSelectedRow(), 0);
                    //System.out.println("modificar"+seleccion);
                     Double notas1 = Double.parseDouble(txtnota1.getText().toString());
                     Double notas2 = Double.parseDouble(txtnota2.getText().toString());
                     Double notas3 = Double.parseDouble(txtnota3.getText().toString());
                     Double notas4 = Double.parseDouble(txtnota4.getText().toString());
        
        ModeloNota modnota = new ModeloNota();
        modnota.setIdAlumno(seleccion2);
        modnota.setIdGrado(seleccion);
        modnota.setNota1(notas1);
        modnota.setNota2(notas2);
        modnota.setNota3(notas3);
        modnota.setNota4(notas4);
                    cliente.actualizarNota(modnota);
                    listaAlumnoss();
                    System.out.println("modificado "+modnota.getIdAlumno()+" "+modnota.getIdGrado()+
                            " "+modnota.getNota1()+" "+modnota.getNota2()+" "+modnota.getNota3()+" "+modnota.getNota4());
                }else if (boton.getName().equals("btneliminar")){
                    try{
                    int seleccion=(int)tblnotas.getValueAt(tblnotas.getSelectedRow(), 2);
                    int seleccion2=(int)tblnotas.getValueAt(tblnotas.getSelectedRow(), 0);
                    System.out.println("eliminar"+seleccion2);
                    cliente.eliminarNota(seleccion2, seleccion);
                    listaAlumnoss();
                    }catch(Exception e){
                         System.out.println("algo pasó");
                    }
                }
            }
        }
    }//GEN-LAST:event_tblnotasMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vistaNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaNotas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncrearnota;
    private javax.swing.JButton btneditarnota;
    private javax.swing.JButton btneliminarnota;
    private javax.swing.JComboBox<String> cmbgrado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblnotas;
    private javax.swing.JTextField txtidalnotas;
    private javax.swing.JTextField txtidgradonotas;
    private javax.swing.JTextField txtnota1;
    private javax.swing.JTextField txtnota2;
    private javax.swing.JTextField txtnota3;
    private javax.swing.JTextField txtnota4;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        vertabla();
    }

    @Override
    public void mousePressed(MouseEvent e) {
          }

    @Override
    public void mouseReleased(MouseEvent e) {
        }

    @Override
    public void mouseEntered(MouseEvent e) {
        }

    @Override
    public void mouseExited(MouseEvent e) {
         }
}
