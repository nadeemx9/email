package email;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class NewJFrame extends javax.swing.JFrame
{

    public NewJFrame()
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        btnSend = new javax.swing.JButton();
        txtToEmail = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSend.setText("SEND");
        btnSend.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(txtToEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(txtToEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSendActionPerformed
    {//GEN-HEADEREND:event_btnSendActionPerformed

        String fromEmail = "ethicalanonymous111@gmail.com";
        String pswd = "anonymous@111";
        String subject = "TEST MESSAGE";
        String text = "Hello World!";
        String toEmail = txtToEmail.getText();

        Pattern pattern = Pattern.compile("([A-Za-z0-9._%+-]{6,30})+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(toEmail);

        if (matcher.matches())
        {
            Properties properties = System.getProperties();
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "465");
            properties.put("mail.smtp.ssl.enable", "true");
            //properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(properties, new Authenticator()
            {
                @Override
                protected PasswordAuthentication getPasswordAuthentication()
                {
                    return new PasswordAuthentication(fromEmail, pswd);
                }

            });

            session.setDebug(true);
            try
            {
                MimeMessage msg = new MimeMessage(session);
                msg.setFrom(new InternetAddress(fromEmail));
                msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
                msg.setSubject(subject);
                msg.setText(text);
                Transport.send(msg);

            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }
        else
        {
            JOptionPane.showMessageDialog(null, "Invalid is not Valid");
        }

    }//GEN-LAST:event_btnSendActionPerformed

    public static void main(String args[])
    {

        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend;
    private javax.swing.JTextField txtToEmail;
    // End of variables declaration//GEN-END:variables
}
