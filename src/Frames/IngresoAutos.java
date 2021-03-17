/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Autos.Carro;
import Autos.Deportivo;
import Autos.Pickup;
import Diagnostico.Diagnostico;
import Usuario.Usuario;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author DV&Camilo
 */
public class IngresoAutos extends javax.swing.JFrame {

    DefaultTableModel tcr = new DefaultTableModel();
    DefaultTableModel tcd = new DefaultTableModel();
    DefaultTableModel tcp = new DefaultTableModel();
    Carro cr;
    Carro dp[];
    Carro pc[];
    Diagnostico dig[];
    int fila;

    String bateria_sin_energia = "60.000";
    int bateria_sin_energia_dias = 1;
    String explocion_de_neumaticos = "90.000";
    int explocion_de_neumaticos_dias = 5;
    String aire_acondicionado_sin_funcionamiento = "100.000";
    int aire_acondicionado_sin_funcionamiento_dias = 9;
    String el_termostato_se_queda_abirto_cerrado = "150.000";
    int el_termostato_se_queda_abirto_cerrado_dias = 10;
    String fusible_y_relevadores_que_fallan = "170.000";
    int fusible_y_relevadores_que_fallan_dias = 12;
    String frenos_defectuosos = "70.000";
    int frenos_defectuosos_dias = 4;
    String filtros_obstruidos = "20.000";
    int filtros_obstruidos_dias = 2;

    public IngresoAutos() {
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        initComponents();
        fila = 0;
        tcr.addColumn("No. puertas");
        tcr.addColumn("Velocidad máx.");
        tcr.addColumn("No. llantas");
        tcr.addColumn("Modelo de llantas");
        tcr.addColumn("Marca");
        tcr.addColumn("Modelo");
        tcr.addColumn("Placa");
        tcr.addColumn("Tipo combustible");
        tcr.addColumn("Fallo");
        tcr.addColumn("Anotación");
        tcr.addColumn("Precio");
        tcr.addColumn("Días");
        this.jtablecarros.setModel(tcr);
        jtablecarros.setEnabled(false);
        tcr.setNumRows(1);

        tcd.addColumn("No. puertas");
        tcd.addColumn("Velocidad máx.");
        tcd.addColumn("No. llantas");
        tcd.addColumn("Modelo de llantas");
        tcd.addColumn("Marca");
        tcd.addColumn("Modelo");
        tcd.addColumn("Placa");
        tcd.addColumn("Tipo combustible");
        tcd.addColumn("Tipo techo");
        tcd.addColumn("Fallo");
        tcd.addColumn("Anotación");
        this.jtabledeportivos.setModel(tcd);
        tcd.setNumRows(1);
        jtabledeportivos.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        jtabledeportivos.getColumnModel().getColumn(9).setPreferredWidth(200);

        tcp.addColumn("No. puertas");
        tcp.addColumn("Velocidad máx.");
        tcp.addColumn("No. llantas");
        tcp.addColumn("Modelo de llantas");
        tcp.addColumn("Marca");
        tcp.addColumn("Modelo");
        tcp.addColumn("Placa");
        tcp.addColumn("Tipo combustible");
        tcp.addColumn("No. pasajeros");
        tcp.addColumn("Peso máximo de carga");
        tcp.addColumn("Fallo");
        tcp.addColumn("Anotación");
        this.jtablepickup.setModel(tcp);
        tcp.setNumRows(1);

        jtablepickup.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        jtablepickup.getColumnModel().getColumn(10).setPreferredWidth(200);
        combomarks.addItem("Ferrari");
        combomarks.addItem("Bugatti");
        combomarks.addItem("Renault");
        combomarks.addItem("Toyota");
        combomarks.addItem("Nissan");
        combomarks.addItem("Audi");
        combomarks.addItem("Kia");
        dp = new Deportivo[100];
        pc = new Pickup[100];
        dig = new Diagnostico[100];
        cr = new Carro();
        jTextFactura.setEditable(false);
        jLabel9.setVisible(false);

        /*AGREGA UN COMBO LA COLUMNA 9 DE LA TABLA CARROS DEPORTIVOS*/
        String[] Diganosticos = {"Batería sin energía", "Explosiones de neumáticos", "Aire acondicionado sin funcionamiento", "El termostato se queda abierto o cerrado", "Fusibles y relevadores que fallan", "Frenos defectuosos", "Filtros obstruidos"};
        JComboBox jcb = new JComboBox(Diganosticos);
        TableColumn tcd = jtabledeportivos.getColumnModel().getColumn(9);
        TableCellEditor tced = new DefaultCellEditor(jcb);
        tcd.setCellEditor(tced);

        /*AGREGA UN COMBO LA COLUMNA 10 DE LA TABLA CARROS PICKUP*/
        TableColumn tcp = jtablepickup.getColumnModel().getColumn(10);
        TableCellEditor tcep = new DefaultCellEditor(jcb);
        tcp.setCellEditor(tcep);

        /*AGREGAR EL TIPO DE COMBUSTIBLE EN LA TABLA DE CARROS DEPORTIVOS*/
        String[] tipoCombustible = {"Gasolina", "Gas", "Electrico", "Hibrido"};
        JComboBox ctc = new JComboBox(tipoCombustible);
        TableColumn ttc = jtabledeportivos.getColumnModel().getColumn(7);
        TableCellEditor tcetc = new DefaultCellEditor(ctc);
        ttc.setCellEditor(tcetc);

        /*AGREGAR EL TIPO DE COMBUSTIBLE EN LA TABLA DE CARROS PICKUP*/
        TableColumn ttcp = jtablepickup.getColumnModel().getColumn(7);
        TableCellEditor tcetcp = new DefaultCellEditor(ctc);
        ttcp.setCellEditor(tcetcp);

        /*AGREGAR EL TIPO DE TECHO EN LA TABLA DE CARROS DEPORTIVOS*/
        String[] tipoTecho = {"Capotable", "Descapotable"};
        JComboBox jct = new JComboBox(tipoTecho);
        TableColumn ttt = jtabledeportivos.getColumnModel().getColumn(8);
        TableCellEditor tcett = new DefaultCellEditor(jct);
        ttt.setCellEditor(tcett);

    }

    void llenar() {
        String marca = combomarks.getSelectedItem().toString();
        switch (marca) {
            case "Ferrari":
                jComboModel.removeAllItems();
                jComboModel.addItem("Ferrari 250 GTO");
                jComboModel.addItem("Ferrari F40");
                jComboModel.addItem("Ferrari F50");
                jComboModel.addItem("Ferrari Enzo");
                jComboModel.addItem("Ferrari LaFerrari");
                break;
            case "Bugatti":
                jComboModel.removeAllItems();
                jComboModel.addItem("Bugatti Type Veyron");
                jComboModel.addItem("Bugatti Type 13");
                jComboModel.addItem("Bugatti Type 32");
                jComboModel.addItem("Bugatti Type 55");
                jComboModel.addItem("Bugatti Type 57");
                break;
            case "Renault":
                jComboModel.removeAllItems();
                jComboModel.addItem("Renault Duster");
                jComboModel.addItem("Renault Captur");
                jComboModel.addItem("Renault Koleos");
                jComboModel.addItem("Renault Alaskan");
                jComboModel.addItem("Renault Stepway");
                break;
            case "Toyota":
                jComboModel.removeAllItems();
                jComboModel.addItem("Toyota corolla");
                jComboModel.addItem("Toyota land cruiser");
                jComboModel.addItem("Toyota hulux");
                jComboModel.addItem("Toyota prado");
                jComboModel.addItem("Toyota 4Runner");
                break;
            case "Nissan":
                jComboModel.removeAllItems();
                jComboModel.addItem("Nissan Kicks");
                jComboModel.addItem("Nissan patrol");
                jComboModel.addItem("Nissan titan");
                jComboModel.addItem("Nissan juke");
                jComboModel.addItem("Nissan rogue");
                break;
            case "Audi":
                jComboModel.removeAllItems();
                jComboModel.addItem("Audi RS 5");
                jComboModel.addItem("Audi A7 sportback");
                jComboModel.addItem("Audi Q2");
                jComboModel.addItem("Audi RS G-tron");
                break;
            case "Kia":
                jComboModel.removeAllItems();
                jComboModel.addItem("Kia Stinger GTS");
                jComboModel.addItem("Kia Sedan");
                break;
            default:
                JOptionPane.showMessageDialog(this, "Selecione una marca");
                break;
        }
    }

    public void modeloatabla() {
        String marca = combomarks.getSelectedItem().toString();
        String modelo = jComboModel.getSelectedItem().toString();
        int fila = jtabledeportivos.getRowCount() - 1;
        int filap = jtablepickup.getRowCount() - 1;
        if (marca.equals("Ferrari") || marca.equals("Bugatti") || marca.equals("Audi") || marca.equals("Kia")) {
            jtabledeportivos.setValueAt(marca, fila, 4);
            jtabledeportivos.setValueAt(modelo, fila, 5);
            fila++;
        } else if (marca.equals("Renault") || marca.equals("Toyota") || marca.equals("Nissan")) {
            jtablepickup.setValueAt(marca, filap, 4);
            jtablepickup.setValueAt(modelo, filap, 5);
            filap++;
        }
    }

    public void agregarDeportivo() {
        int fila_deportivos = tcd.getRowCount() - 1;
        dp[fila] = new Deportivo(jtabledeportivos.getValueAt(fila_deportivos, 8).toString(), jtabledeportivos.getValueAt(fila_deportivos, 0).toString(), jtabledeportivos.getValueAt(fila_deportivos, 1).toString(),
                jtabledeportivos.getValueAt(fila_deportivos, 2).toString(), jtabledeportivos.getValueAt(fila_deportivos, 3).toString(), jtabledeportivos.getValueAt(fila_deportivos, 4).toString(),
                jtabledeportivos.getValueAt(fila_deportivos, 5).toString(), jtabledeportivos.getValueAt(fila_deportivos, 6).toString(), jtabledeportivos.getValueAt(fila_deportivos, 7).toString());
        fila++;
        tcd.setRowCount(fila + 1);
        JOptionPane.showMessageDialog(this, dp[fila_deportivos].validad_placa());
    }

    public void deportivotocarro() {
        JOptionPane.showMessageDialog(this, "SU AUTO SERÁ AGREGRADO A LA TABLA INFERIOR Y ESTARÁ LISTO PARA LA RESERVA");
        int filac = jtablecarros.getRowCount() - 1;
        int filad = jtabledeportivos.getRowCount() - 2;
        jtablecarros.setValueAt(jtabledeportivos.getValueAt(filad, 0), filac, 0);
        jtablecarros.setValueAt(jtabledeportivos.getValueAt(filad, 1), filac, 1);
        jtablecarros.setValueAt(jtabledeportivos.getValueAt(filad, 2), filac, 2);
        jtablecarros.setValueAt(jtabledeportivos.getValueAt(filad, 3), filac, 3);
        jtablecarros.setValueAt(jtabledeportivos.getValueAt(filad, 4), filac, 4);
        jtablecarros.setValueAt(jtabledeportivos.getValueAt(filad, 5), filac, 5);
        jtablecarros.setValueAt(jtabledeportivos.getValueAt(filad, 6), filac, 6);
        jtablecarros.setValueAt(jtabledeportivos.getValueAt(filad, 7), filac, 7);
        jtablecarros.setValueAt(jtabledeportivos.getValueAt(filad, 9), filac, 8);
        jtablecarros.setValueAt(jtabledeportivos.getValueAt(filad, 10), filac, 9);
        filac++;
        filad++;
        tcr.setRowCount(filac + 1);
    }

    public void agregarPickup() {
        int fila_pickip = tcp.getRowCount() - 1;
        pc[fila] = new Pickup(jtablepickup.getValueAt(fila_pickip, 8).toString(), jtablepickup.getValueAt(fila_pickip, 9).toString(),
                jtablepickup.getValueAt(fila_pickip, 0).toString(), jtablepickup.getValueAt(fila_pickip, 1).toString(), jtablepickup.getValueAt(fila_pickip, 2).toString(),
                jtablepickup.getValueAt(fila_pickip, 3).toString(), jtablepickup.getValueAt(fila_pickip, 4).toString(),
                jtablepickup.getValueAt(fila_pickip, 5).toString(), jtablepickup.getValueAt(fila_pickip, 6).toString(),
                jtablepickup.getValueAt(fila_pickip, 7).toString());
        fila++;
        tcp.setRowCount(fila + 1);
        JOptionPane.showMessageDialog(this, pc[fila_pickip].validad_placa());

    }

    public void pickuptocarro() {
        JOptionPane.showMessageDialog(this, "SU AUTO SERÁ AGREGRADO A LA TABLA INFERIOR Y ESTARÁ LISTO PARA LA RESERVA");
        int filac = jtablecarros.getRowCount() - 1;
        int filap = jtablepickup.getRowCount() - 2;
        jtablecarros.setValueAt(jtablepickup.getValueAt(filap, 0), filac, 0);
        jtablecarros.setValueAt(jtablepickup.getValueAt(filap, 1), filac, 1);
        jtablecarros.setValueAt(jtablepickup.getValueAt(filap, 2), filac, 2);
        jtablecarros.setValueAt(jtablepickup.getValueAt(filap, 3), filac, 3);
        jtablecarros.setValueAt(jtablepickup.getValueAt(filap, 4), filac, 4);
        jtablecarros.setValueAt(jtablepickup.getValueAt(filap, 5), filac, 5);
        jtablecarros.setValueAt(jtablepickup.getValueAt(filap, 6), filac, 6);
        jtablecarros.setValueAt(jtablepickup.getValueAt(filap, 7), filac, 7);
        jtablecarros.setValueAt(jtablepickup.getValueAt(filap, 10), filac, 8);
        jtablecarros.setValueAt(jtablepickup.getValueAt(filap, 11), filac, 9);
        filac++;
        filap++;
        tcr.setRowCount(filac + 1);
    }

    public void precios_dias_deportivo() {
        int filac = jtablecarros.getRowCount() - 2;
        int filad = jtabledeportivos.getRowCount() - 2;
        String dañodepor = jtabledeportivos.getValueAt(filad, 9).toString();
        if (dañodepor.equalsIgnoreCase("Batería sin energía")) {
            jtablecarros.setValueAt(bateria_sin_energia, filac, 10);
            jtablecarros.setValueAt(bateria_sin_energia_dias + " Dias", filac, 11);
        } else if (dañodepor.equalsIgnoreCase("Explosiones de neumáticos")) {
            jtablecarros.setValueAt(explocion_de_neumaticos, filac, 10);
            jtablecarros.setValueAt(explocion_de_neumaticos_dias + " Dias", filac, 11);
        } else if (dañodepor.equalsIgnoreCase("Aire acondicionado sin funcionamiento")) {
            jtablecarros.setValueAt(aire_acondicionado_sin_funcionamiento, filac, 10);
            jtablecarros.setValueAt(aire_acondicionado_sin_funcionamiento_dias + " Dias", filac, 11);
        } else if (dañodepor.equalsIgnoreCase("El termostato se queda abierto o cerrado")) {
            jtablecarros.setValueAt(el_termostato_se_queda_abirto_cerrado, filac, 10);
            jtablecarros.setValueAt(el_termostato_se_queda_abirto_cerrado_dias + " Dias", filac, 11);
        } else if (dañodepor.equalsIgnoreCase("Fusibles y relevadores que fallan")) {
            jtablecarros.setValueAt(fusible_y_relevadores_que_fallan, filac, 10);
            jtablecarros.setValueAt(fusible_y_relevadores_que_fallan_dias + " Dias", filac, 11);
        } else if (dañodepor.equalsIgnoreCase("Frenos defectuosos")) {
            jtablecarros.setValueAt(frenos_defectuosos, filac, 10);
            jtablecarros.setValueAt(frenos_defectuosos_dias + " Dias", filac, 11);
        } else if (dañodepor.equalsIgnoreCase("Filtros obstruidos")) {
            jtablecarros.setValueAt(filtros_obstruidos, filac, 10);
            jtablecarros.setValueAt(filtros_obstruidos_dias + " Dias", filac, 11);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor selecione un tipo de daño");
        }
        filad++;
        filac++;
    }

    public void precios_dias_Pickup() {
        int filac = jtablecarros.getRowCount() - 2;
        int filap = jtablepickup.getRowCount() - 2;
        String dañopick = jtablepickup.getValueAt(filap, 10).toString();
        if (dañopick.equalsIgnoreCase("Batería sin energía")) {
            jtablecarros.setValueAt(bateria_sin_energia, filac, 10);
            jtablecarros.setValueAt(bateria_sin_energia_dias + " Dias", filac, 11);
        } else if (dañopick.equalsIgnoreCase("Explosiones de neumáticos")) {
            jtablecarros.setValueAt(explocion_de_neumaticos, filac, 10);
            jtablecarros.setValueAt(explocion_de_neumaticos_dias + " Dias", filac, 11);
        } else if (dañopick.equalsIgnoreCase("Aire acondicionado sin funcionamiento")) {
            jtablecarros.setValueAt(aire_acondicionado_sin_funcionamiento, filac, 10);
            jtablecarros.setValueAt(aire_acondicionado_sin_funcionamiento_dias + " Dias", filac, 11);
        } else if (dañopick.equalsIgnoreCase("El termostato se queda abierto o cerrado")) {
            jtablecarros.setValueAt(el_termostato_se_queda_abirto_cerrado, filac, 10);
            jtablecarros.setValueAt(el_termostato_se_queda_abirto_cerrado_dias + " Dias", filac, 11);
        } else if (dañopick.equalsIgnoreCase("Fusibles y relevadores que fallan")) {
            jtablecarros.setValueAt(fusible_y_relevadores_que_fallan, filac, 10);
            jtablecarros.setValueAt(fusible_y_relevadores_que_fallan_dias + " Dias", filac, 11);
        } else if (dañopick.equalsIgnoreCase("Frenos defectuosos")) {
            jtablecarros.setValueAt(frenos_defectuosos, filac, 10);
            jtablecarros.setValueAt(frenos_defectuosos_dias + " Dias", filac, 11);
        } else if (dañopick.equalsIgnoreCase("Filtros obstruidos")) {
            jtablecarros.setValueAt(filtros_obstruidos, filac, 10);
            jtablecarros.setValueAt(filtros_obstruidos_dias + " Dias", filac, 11);

        }
        filap++;
        filac++;
    }

    public void realizarReserva() {
        int seleccion = JOptionPane.showConfirmDialog(null, "REVISE QUE TODOS LOS DATOS INGRESODOS COINCIDAN CON EL DE SU AUTO", "¿DESEA REALIZAR LA RESERVA CON EL MECÁNICO?", JOptionPane.YES_NO_CANCEL_OPTION);
        switch (seleccion) {
            case JOptionPane.NO_OPTION:
                JOptionPane.showMessageDialog(null, "LA RESERVA NO SE HA REALIZADO");
                break;
            case JOptionPane.YES_OPTION:
                int fila = tcr.getRowCount() - 1;
                dig[fila] = new Diagnostico(jtablecarros.getValueAt(0, 8).toString(), jtablecarros.getValueAt(0, 10).toString(),
                        jtablecarros.getValueAt(0, 11).toString(), jtablecarros.getValueAt(0, 9).toString());
                fila++;
                JOptionPane.showMessageDialog(this, "Su reserva se ha realizado con éxito");

                for (int i = 0; i < jtablepickup.getRowCount(); i++) {
                    tcp.removeRow(i);
                    i -= 1;
                }
                tcp.setNumRows(1);

                for (int k = 0; k < jtabledeportivos.getRowCount() - 1; k++) {
                    tcd.removeRow(k);
                    k -= 1;
                }
                tcd.setNumRows(1);

                break;

            case JOptionPane.CANCEL_OPTION:
                JOptionPane.showMessageDialog(null, "LA RESERVA NO SE HA REALIZADO");
                break;
            default:
                JOptionPane.showMessageDialog(null, "LA RESERVA NO SE HA REALIZADO");
                break;
        }
    }

    public void limpiarLista() {
        for (int k = 0; k < jtablecarros.getRowCount() - 1; k++) {
            tcr.removeRow(k);
            k -= 1;
        }
        tcr.setNumRows(1);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnaggcarros_deportivos = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtabledeportivos = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtablepickup = new javax.swing.JTable();
        jButtonLimpiar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtablecarros = new javax.swing.JTable();
        combomarks = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jComboModel = new javax.swing.JComboBox<>();
        jButtonAddPc = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButtonRerserva = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextFactura = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnaggcarros_deportivos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnaggcarros_deportivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/checkoscu.png"))); // NOI18N
        btnaggcarros_deportivos.setText("Agregar");
        btnaggcarros_deportivos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/check_40622 (1).png"))); // NOI18N
        btnaggcarros_deportivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaggcarros_deportivosActionPerformed(evt);
            }
        });
        getContentPane().add(btnaggcarros_deportivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 230, 150, 40));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/exit_17886.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 0, -1, -1));

        jtabledeportivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtabledeportivos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(jtabledeportivos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 1310, 120));

        jtablepickup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jtablepickup);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 1310, 100));

        jButtonLimpiar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borraroscu.png"))); // NOI18N
        jButtonLimpiar.setText("Limpiar Lista");
        jButtonLimpiar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1486503744-backspace-clean-clear-delete-remove-erase_81258.png"))); // NOI18N
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 530, -1, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cotizacion");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Carros deportivos");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Pickup");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingrese su auto");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jtablecarros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtablecarros);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 1310, 50));

        combomarks.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la marca" }));
        combomarks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combomarksActionPerformed(evt);
            }
        });
        getContentPane().add(combomarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 154, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Modelo");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, -1, 20));

        getContentPane().add(jComboModel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 150, -1));

        jButtonAddPc.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonAddPc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/checkoscu.png"))); // NOI18N
        jButtonAddPc.setText("Agregar");
        jButtonAddPc.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/check_40622 (1).png"))); // NOI18N
        jButtonAddPc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddPcActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAddPc, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 400, 150, 40));

        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 102, 102));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/add_icon-icons.com_74429.png"))); // NOI18N
        jButton1.setText("Agregar Modelo a la tabla");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 250, 40));

        jButtonRerserva.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonRerserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/to_do_icon_153795.png"))); // NOI18N
        jButtonRerserva.setText("REALIZAR LA RESERVA");
        jButtonRerserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRerservaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRerserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 520, 312, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/one-finger-click-black-hand-symbol_icon-icons.com_64350.png"))); // NOI18N
        jLabel6.setText("Click Aquí para ver la factura");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 560, 320, 40));

        jLabel8.setText("jLabel8");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/restart_back_left_arrow_6022.png"))); // NOI18N
        jLabel9.setText("Volver a la interfaz Anterior");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 470, 320, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Webp.net-resizeimage.jpg"))); // NOI18N
        jLabel7.setText("Volver Al La interfz Anterior");
        jLabel7.setMaximumSize(new java.awt.Dimension(1430, 790));
        jLabel7.setMinimumSize(new java.awt.Dimension(1430, 790));
        jLabel7.setPreferredSize(new java.awt.Dimension(1430, 790));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -60, 1360, 700));

        jScrollPane5.setViewportView(jTextFactura);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 470, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combomarksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combomarksActionPerformed
        llenar();
    }//GEN-LAST:event_combomarksActionPerformed

    private void jButtonAddPcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddPcActionPerformed
        agregarPickup();
        pickuptocarro();
        precios_dias_Pickup();
    }//GEN-LAST:event_jButtonAddPcActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        modeloatabla();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonRerservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRerservaActionPerformed
        realizarReserva();
    }//GEN-LAST:event_jButtonRerservaActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        Usuario us = new Usuario();
        int fila = jtablecarros.getSelectedRow();
        fila++;
        int seleccion = JOptionPane.showConfirmDialog(null, "¿YA REALIZO LA RESERVA CON EL MECANICO?", "VER FACTURA", JOptionPane.YES_NO_CANCEL_OPTION);
        jTextFactura.setText("EMPRESA DE AUTOS ROSTER \n\n NIT: 3454276512 \n\nBuenos dias Señor/a Un placer saludarle, Se le informa que su auto un: "
                + jtablecarros.getValueAt(fila, 5) + ", Registrado con el numero de placa: \n" + jtablecarros.getValueAt(fila, 6) + " Ha entrado en etapa de revicion"
                + " Para mentenimiento y reparacion debido a: " + jtablecarros.getValueAt(fila, 8) + " Y con las siguentes anotaciones: \n"
                + jtablecarros.getValueAt(fila, 9) + "\nEs por esto que su auto permanecera en nuestro taller por los proximos " + jtablecarros.getValueAt(fila, 11)
                + " \nEl coste de la repacion será de: " + jtablecarros.getValueAt(fila, 10) + "Pesos colombianos y debera ser pagado en los proximos 5 dias habiles"
                + "\nDe no ser así NO SE REALIZARA MANTENIMIENTO A SU VEHICULO\n Acepamos pagos por: \n *BANCOLOBIA \n*DAVIBIENDA \n* BANCOAVEVILLAS \n* BANCOAGRARIO"
                + "\n*EFECTY \n*SUPERGIROS \n* DAVIPLATA \n*NEQUI \n*PSE");
        switch (seleccion) {
            case JOptionPane.NO_OPTION:
                jTextFactura.setVisible(false);
                jScrollPane5.setVisible(false);
                jPanel1.setVisible(false);
                JOptionPane.showMessageDialog(this, "Por favor realize la reserva");
                break;
            case JOptionPane.YES_NO_OPTION:
                btnaggcarros_deportivos.setVisible(false);
                jPanel1.setVisible(true);
                jLabel6.setVisible(false);
                jPanel1.setVisible(true);
                jLabel9.setVisible(true);
                jTextFactura.setVisible(true);
                jScrollPane1.setVisible(false);
                jScrollPane2.setVisible(false);
                jScrollPane3.setVisible(false);
                jScrollPane5.setVisible(true);
                jButtonRerserva.setVisible(false);
                jLabel2.setVisible(false);
                jButtonAddPc.setVisible(false);
                jButtonAddPc.setVisible(false);
                jButton1.setVisible(false);
                jButtonLimpiar.setVisible(false);
                jComboModel.setVisible(false);
                jLabel5.setVisible(false);
                combomarks.setVisible(false);
                jLabel1.setVisible(false);
                jLabel3.setVisible(false);
                jLabel4.setVisible(false);

                break;
            case JOptionPane.CANCEL_OPTION:
                JOptionPane.showMessageDialog(this, "Continue con su reserva");
                break;

        }
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        limpiarLista();
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        jLabel6.setVisible(true);
        jLabel9.setVisible(false);
        jTextFactura.setVisible(false);
        jScrollPane1.setVisible(true);
        jScrollPane2.setVisible(true);
        jScrollPane3.setVisible(true);
        jButtonRerserva.setVisible(true);
        jButtonAddPc.setVisible(true);
        jButtonAddPc.setVisible(true);
        jButton1.setVisible(true);
        jButtonLimpiar.setVisible(true);
        jComboModel.setVisible(true);
        jLabel2.setVisible(true);
        jLabel5.setVisible(true);
        combomarks.setVisible(true);
        jLabel1.setVisible(true);
        btnaggcarros_deportivos.setVisible(true);
        jLabel3.setVisible(true);
        jPanel1.setVisible(false);

    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        dispose();
        cr.Despedida();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void btnaggcarros_deportivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaggcarros_deportivosActionPerformed
        agregarDeportivo();
        deportivotocarro();
        precios_dias_deportivo();
    }//GEN-LAST:event_btnaggcarros_deportivosActionPerformed

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
            java.util.logging.Logger.getLogger(IngresoAutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresoAutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresoAutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresoAutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresoAutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaggcarros_deportivos;
    private javax.swing.JComboBox<String> combomarks;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAddPc;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JButton jButtonRerserva;
    private javax.swing.JComboBox<String> jComboModel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextPane jTextFactura;
    private javax.swing.JTable jtablecarros;
    private javax.swing.JTable jtabledeportivos;
    private javax.swing.JTable jtablepickup;
    // End of variables declaration//GEN-END:variables
}
