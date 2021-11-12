package es.deusto.ingenieria.sd.strava.client.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import es.deusto.ingenieria.sd.strava.client.controller.LoginController;

public class LoginDialog {
	
	private LoginController controller;
	private String email = "thomas.e2001@gmail.com";
	private String password = "$!9PhNz,";

	public LoginDialog(LoginController controller) {
		this.controller = controller;
	}


	public boolean LoginD() {
		JFrame f = new JFrame("STRAVA LOGIN");
		
		final JLabel lemail= new JLabel("email");
		lemail.setBounds(120, 20, 150, 20);
		
		final JTextField emailBox = new JTextField();
		emailBox.setBounds(120, 50, 150, 20);
		emailBox.setText("thomas.e2001@gmail.com");
		
		final JLabel lpass= new JLabel("password");
		lpass.setBounds(120, 70, 150, 20);
		
		final JTextField pass = new JTextField();
		pass.setBounds(120, 100, 150, 20);
		pass.setText("$!9PhNz,");
		
		final JLabel lname= new JLabel("name");
		lname.setBounds(120, 120, 150, 20);
		
		final JTextField name = new JTextField();
		name.setBounds(120, 140, 150, 20);
		
		final JLabel lweigth= new JLabel("weigth");
		lweigth.setBounds(120, 160, 150, 20);
		
		final JTextField weigth = new JTextField();
		weigth.setBounds(120, 180, 40, 20);
		

		final JLabel lheight= new JLabel("height");
		lheight.setBounds(180, 160, 150, 20);
		
		final JTextField height = new JTextField();
		height.setBounds(180, 180, 40, 20);
		
		final JLabel lmaxrate= new JLabel("max rate");
		lmaxrate.setBounds(120, 200, 150, 20);
		
		final JTextField maxrate = new JTextField();
		maxrate.setBounds(120, 220, 40, 20);
		
		final JLabel lminrate= new JLabel("min rate");
		lminrate.setBounds(180, 200, 150, 20);
		
		final JTextField minrate = new JTextField();
		minrate.setBounds(180, 220, 40, 20);
		
		
		JButton b = new JButton("LOGIN");
		b.setBounds(100, 250, 95, 30);
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
	         /*   JOptionPane.showMessageDialog(null, "Login request sent");
				email.setText("");
				pass.setText("");
*/
				JOptionPane.showMessageDialog(null, "Login request sent");
				String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex(password);
				JOptionPane.showMessageDialog(null,"\t* Password hash: " + sha1);
				System.out.println("lanza login");
				boolean result = controller.login(email, sha1);
				System.out.println("devuelve login");
				JOptionPane.showMessageDialog(null,"Login result");
				
				JOptionPane.showMessageDialog(null,"Token: " + controller.getToken());
				//reset text fields
				emailBox.setText("");
				pass.setText("");

				// Send login

			}
		});
		
		JButton c = new JButton("REGISTER");
		c.setBounds(200, 250, 95, 30);
		c.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				c.setBounds(200, 300, 95, 30);
				b.setVisible(false);
				c.setVisible(false);
				
				lname.setVisible(true);
				name.setVisible(true);
				
				lweigth.setVisible(true);
				weigth.setVisible(true);
				
				lheight.setVisible(true);
				height.setVisible(true);
				
				lmaxrate.setVisible(true);
				maxrate.setVisible(true);
				
				lminrate.setVisible(true);
				minrate.setVisible(true);

			}
		});
		
		JButton d = new JButton("SEND");
		d.setBounds(200, 250, 95, 30);
		d.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				c.setBounds(200, 250, 95, 30);
				b.setVisible(true);
				c.setVisible(true);

				
				lname.setVisible(false);
				name.setVisible(false);
				
				lweigth.setVisible(false);
				weigth.setVisible(false);
				
				lheight.setVisible(false);
				height.setVisible(false);
				
				lmaxrate.setVisible(false);
				maxrate.setVisible(false);
				
				lminrate.setVisible(false);
				minrate.setVisible(false);

			}
		});
		
		f.add(b);
		f.add(c);
		f.add(d);
		f.add(emailBox);
		f.add(lemail);
		
		f.add(pass);
		f.add(lpass);
		
		//register fields
		f.add(lname);
		f.add(name);
		lname.setVisible(false);
		name.setVisible(false);
		
		
		f.add(lmaxrate);
		f.add(maxrate);
		lmaxrate.setVisible(false);
		maxrate.setVisible(false);
		
		f.add(lminrate);
		f.add(minrate);
		lminrate.setVisible(false);
		minrate.setVisible(false);
		
	
		f.add(lweigth);
		f.add(weigth);
		lweigth.setVisible(false);
		weigth.setVisible(false);

		
		f.add(lheight);
		f.add(height);
		lheight.setVisible(false);
		height.setVisible(false);
		
		f.setSize(400, 400);
		f.setLayout(null);
		f.setVisible(true);
		
		boolean result=true;
		return result;

	}

	public void logout() {
		System.out.println(" - Logout from the server...");
		this.controller.logout();
		System.out.println("\t* Logout success!");

	}

}