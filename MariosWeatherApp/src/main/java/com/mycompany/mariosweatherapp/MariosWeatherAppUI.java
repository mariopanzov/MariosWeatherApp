
package com.mycompany.mariosweatherapp;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.BorderFactory;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.threeten.bp.LocalDate;
import org.threeten.bp.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MariosWeatherAppUI extends javax.swing.JFrame {

    private MariosWeatherApp mariosWeatherApp;
    private List<LocalDate> dates;
    
    //ImageIcon wSun = new ImageIcon("src/main/resources/sun.png");
    //ImageIcon wCloud = new ImageIcon("src/main/resources/cloud.png");
    //ImageIcon wRain = new ImageIcon("src/main/resources/rain.png");
    //ImageIcon wThunder = new ImageIcon("src/main/resources/thunder.png");
    
    // getting images from class path, help: https://stackoverflow.com/questions/6373021/how-to-includes-all-images-in-jar-file-using-eclipse
    private ImageIcon wSun = new ImageIcon(getClass().getResource("/sun.png"));
    private ImageIcon wCloud = new ImageIcon(getClass().getResource("/cloud.png"));
    private ImageIcon wRain = new ImageIcon(getClass().getResource("/rain.png"));
    private ImageIcon wThunder = new ImageIcon(getClass().getResource("/thunder.png"));
    
    private String currentCity = "";
    
    private HistoricalWeatherData historicalWeatherData;
    private TodaysWeatherData todaysWeatherData;
    
    //for periodically calling updateTodaysWeatherData()
    private Runnable helloRunnable;
    ScheduledExecutorService executor;
    private boolean isUpdating = false;
    
    /**
     * Creates new form MariosWeatherAppUI
     */
    public MariosWeatherAppUI() {
        initComponents();
        populateDateComboBox();
        mariosWeatherApp = new MariosWeatherApp();
        historicalWeatherData = new HistoricalWeatherData();
        todaysWeatherData = new TodaysWeatherData();
        
        currentCity = (String) jTextField2.getText();
        
        //doing a periodic task, source:https://stackoverflow.com/questions/12908412/print-hello-world-every-x-seconds
        helloRunnable = new Runnable() {
            public void run() {
                updateTodaysWeatherData();
            }
        };
        
        updateTodaysWeatherData();
        
    }
    private void stopRunningUpdateTodaysWeatherData() {
        if(this.isUpdating) {
            executor.shutdown();
            this.isUpdating = false;
        }
    }
    private void startRunningUpdateTodaysWeatherData() {
        if(!this.isUpdating) {
            executor = Executors.newScheduledThreadPool(1);
            executor.scheduleAtFixedRate(helloRunnable, 0, 3, TimeUnit.SECONDS);
            this.isUpdating = true;
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

        jOptionPane1 = new javax.swing.JOptionPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mario's Weather App");

        jLabel1.setText("Date:");

        jLabel2.setText("City:");

        jComboBox2.setToolTipText("Select a Date");
        jComboBox2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton1.setLabel("Chart temperature");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jLabel3.setText("Temperature History");

        jTextField1.setToolTipText("Search For City");

        jLabel10.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)))
                .addContainerGap(507, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(229, 229, 229))
        );

        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel4.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jLabel4.setText("Today's Weather");

        jLabel5.setText("City:");

        jTextField2.setText("Maribor");
        jTextField2.setToolTipText("Search For CIty");

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rain.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Cantarell", 1, 36)); // NOI18N
        jLabel7.setText("-//-");

        jLabel8.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jLabel8.setText("-//-");

        jLabel9.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jLabel9.setText("-//-");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        //System.out.println((String) jComboBox2.getSelectedItem());
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String city = (String) jTextField1.getText().replace(" ", "+");
        
        LocalDate date = dates.get(jComboBox2.getSelectedIndex());
        
        historicalWeatherData = mariosWeatherApp.pullHistoricalWeatherData(city, date);
        
        if(historicalWeatherData != null) {
            initialiseChart(historicalWeatherData.getHourly(HistoricalWeatherData.hourlyParameterDefs.temperature_2m));
            jLabel10.setText(": " + historicalWeatherData.getLocationData().getCity());
        } else {
            infoBox("Historical Weather API will not be called...", "City not found");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        currentCity = (String) jTextField2.getText().replace(" ", "+");
        updateTodaysWeatherData();
    }//GEN-LAST:event_jButton2ActionPerformed

    
    private void updateTodaysWeatherData() {
        
        todaysWeatherData = mariosWeatherApp.pullForecastWeatherData(currentCity);
        if(todaysWeatherData != null) {
            startRunningUpdateTodaysWeatherData();
            
            jLabel9.setText(todaysWeatherData.getLocationData().getCity());
            jLabel7.setText(todaysWeatherData.getCurrentTemperature().toString() + "C\u00b0");
            String weather = "";

            int x = todaysWeatherData.getCurrentWeatherCode();

            //weather code meaning, help: https://gist.github.com/Oskar1504/c315a059738437ed224e88f81cc45512
            if (x == 0) {
                weather = "Clear";
                jLabel6.setIcon(wSun);
            } else if (x < 4) {
                weather = "Cloudy";
                jLabel6.setIcon(wCloud);
            } else if (x > 60 && x < 66) {
                weather = "Rain";
                jLabel6.setIcon(wRain);
            } else if (x > 79 && x < 84) {
                weather = "Rain Showers";
                jLabel6.setIcon(wRain);
            } else if (x > 94 && x < 100) {
                weather = "Thunderstorm";
                jLabel6.setIcon(wThunder);
            }

            jLabel8.setText(weather);
        } else {
            stopRunningUpdateTodaysWeatherData();
            infoBox("Weather Forecast API will not be called...", "City not found");
        }
    }
    
    //Creating a line chart in JFrame, source: https://zetcode.com/java/jfreechart/
    private void initialiseChart(List<Object> stringData) {
        
        XYDataset dataset = createDataset(stringData);
        JFreeChart chart = createChart(dataset);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);

        jPanel2.removeAll();
        jPanel2.add(chartPanel, BorderLayout.CENTER);
        jPanel2.validate();

        //pack();
        //setTitle("Line chart");
        //setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private XYDataset createDataset(List<Object> stringData) {

        var series = new XYSeries("Teperature C\u00b0");
        
        for(int i = 0; i < stringData.size(); i++)
        {
            series.add(i, (Double) stringData.get(i));
        }
        
        var dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        return dataset;
    }

    private JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createXYLineChart(
                "",
                "Hour of day",
                "Teperature C\u00b0",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                false,
                false
        );

        XYPlot plot = chart.getXYPlot();

        var renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        chart.getLegend().setFrame(BlockBorder.NONE);

        //chart.setTitle(new TextTitle("Temperature",
                //new Font("Serif", java.awt.Font.BOLD, 18)
        //)
        //);

        return chart;
    }
    
    private void populateDateComboBox() {
        
        //the available dates for historical weatherdata... can be changed to any range...
        dates = generateDateRange(LocalDate.now().minusDays(8), LocalDate.now().minusDays(1));
        for (LocalDate date : dates) {
            
            jComboBox2.addItem(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }
    }

    private List<LocalDate> generateDateRange(LocalDate start, LocalDate end) {
        
        List<LocalDate> dates = new ArrayList<>();
        LocalDate current = start;
        while (!current.isAfter(end)) {
            
            dates.add(current);
            current = current.plusDays(1);
        }
        return dates;
    }
    
    private void infoBox(String infoMessage, String titleBar) {
        jOptionPane1.showMessageDialog(null, infoMessage, titleBar, JOptionPane.ERROR_MESSAGE);
    }
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
            java.util.logging.Logger.getLogger(MariosWeatherAppUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MariosWeatherAppUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MariosWeatherAppUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MariosWeatherAppUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MariosWeatherAppUI().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox2;
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
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
