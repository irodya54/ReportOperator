import Entity.Operator;
import Entity.SetupPlan;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Stream;

import static javax.swing.BoxLayout.*;

public class LoadShiftReport {
    private JFrame frame;
    private JButton loadSetupPlansButton;
    private JButton loadReportButton;
    private JButton saveReportButton;
    private JTable table;
    private Operator operator;
    private JLabel priemSmenyLabel;
    private JLabel chistkaPristrelkaLabel;
    private JLabel polomkaTOLabel;
    private JLabel moMetallLabel;
    private JLabel noSPLabel;
    private JLabel enterMetallLabel;
    private JLabel outRaskroyDetaelsLabel;
    private JLabel agreementLabel;
    private JLabel settingsLabel;
    private JLabel assignmentLabel;
    private JLabel cleaningLabel;
    private JLabel otherLabel;
    private JComboBox<Operator> operators;
    private LocalDate date;
    private ArrayList<SetupPlan> plans;
    private ArrayList<Operator> operatorArrayList;

    public static void main(String[] args) {
        LoadShiftReport loadShiftReport = new LoadShiftReport();
        loadShiftReport.go();
    }

    private void go() {
        frame = new JFrame("Отчет оператора");

        loadSetupPlansButton = new JButton("Загрузить Планы наладок");

        saveReportButton = new JButton("Сохранить отчет в Excel");
        loadReportButton = new JButton("Загрузить отчет о смене");

        loadSetupPlansButton.addActionListener(new LoadSetupPlanListener());

        table = new JTable(10, 2);


        frame.getContentPane().add(BorderLayout.NORTH, loadSetupPlansButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640,700);
        frame.setVisible(true);
        frame.getContentPane().add(BorderLayout.CENTER, table);

    }


    private class LoadSetupPlanListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {


        }
    }

    private void loadFiles(File[] selectedFiles) {

        try {
            for (File selectedFile : selectedFiles) {
                Document document = Jsoup.parse(selectedFile);

                String title = document.title().replaceFirst("/", "");
                String name = title.substring(title.indexOf('/')+2);

                String timeSetupPlan = document.getElementsByTag("nobr").toString();
                String time = timeSetupPlan
                        .substring(timeSetupPlan.indexOf('>') + 1, timeSetupPlan.indexOf('[')).
                        replace(" : ", ":").
                        trim();
                int[] arrayMinutes = Stream.of(time.split(":")).mapToInt(Integer::valueOf).toArray();
                Double minute = ((arrayMinutes[0] * 60) + arrayMinutes[1] + (double) arrayMinutes[2] / 60);

                plans.add(new SetupPlan(name, minute));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
