package ui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;

import schedulingIOModel.Network;
import schedulingIOModel.Network.NetworkType;

public class NetworkPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox<NetworkType> comboBoxNetworkType;
	private JSpinner spinnerStartTime;
	private JSpinner spinnerSlots;
	private JSpinner spinnerThroughput;
	
	/**
	 * Create the panel.
	 */
	public NetworkPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNetwork = new JLabel("Network");
		lblNetwork.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNetwork = new GridBagConstraints();
		gbc_lblNetwork.insets = new Insets(0, 0, 5, 5);
		gbc_lblNetwork.gridx = 0;
		gbc_lblNetwork.gridy = 0;
		add(lblNetwork, gbc_lblNetwork);
		
		JLabel lblNetworkType = new JLabel("Network type");
		GridBagConstraints gbc_lblNetworkType = new GridBagConstraints();
		gbc_lblNetworkType.insets = new Insets(0, 0, 5, 5);
		gbc_lblNetworkType.gridx = 0;
		gbc_lblNetworkType.gridy = 1;
		add(lblNetworkType, gbc_lblNetworkType);
		
		comboBoxNetworkType = new JComboBox<NetworkType>();
		comboBoxNetworkType.setModel(new DefaultComboBoxModel<NetworkType>(NetworkType.values()));
		GridBagConstraints gbc_comboBoxNetworkType = new GridBagConstraints();
		gbc_comboBoxNetworkType.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxNetworkType.gridx = 1;
		gbc_comboBoxNetworkType.gridy = 1;
		add(comboBoxNetworkType, gbc_comboBoxNetworkType);
		
		JLabel lblSlots = new JLabel("Slots");
		GridBagConstraints gbc_lblSlots = new GridBagConstraints();
		gbc_lblSlots.insets = new Insets(0, 0, 5, 5);
		gbc_lblSlots.gridx = 0;
		gbc_lblSlots.gridy = 2;
		add(lblSlots, gbc_lblSlots);
		
		spinnerSlots = new JSpinner();
		spinnerSlots.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		GridBagConstraints gbc_spinnerSlots = new GridBagConstraints();
		gbc_spinnerSlots.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerSlots.gridx = 1;
		gbc_spinnerSlots.gridy = 2;
		add(spinnerSlots, gbc_spinnerSlots);
		
		JLabel lblThroughput = new JLabel("Throughput");
		GridBagConstraints gbc_lblThroughput = new GridBagConstraints();
		gbc_lblThroughput.insets = new Insets(0, 0, 5, 5);
		gbc_lblThroughput.gridx = 0;
		gbc_lblThroughput.gridy = 3;
		add(lblThroughput, gbc_lblThroughput);
		
		spinnerThroughput = new JSpinner();
		spinnerThroughput.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		GridBagConstraints gbc_spinnerThroughput = new GridBagConstraints();
		gbc_spinnerThroughput.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerThroughput.gridx = 1;
		gbc_spinnerThroughput.gridy = 3;
		add(spinnerThroughput, gbc_spinnerThroughput);
		
		JLabel lblStartTime = new JLabel("Start time");
		GridBagConstraints gbc_lblStartTime = new GridBagConstraints();
		gbc_lblStartTime.insets = new Insets(0, 0, 0, 5);
		gbc_lblStartTime.gridx = 0;
		gbc_lblStartTime.gridy = 4;
		add(lblStartTime, gbc_lblStartTime);
		
		spinnerStartTime = new JSpinner();
		spinnerStartTime.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		GridBagConstraints gbc_spinnerStartTime = new GridBagConstraints();
		gbc_spinnerStartTime.gridx = 1;
		gbc_spinnerStartTime.gridy = 4;
		add(spinnerStartTime, gbc_spinnerStartTime);

	}
	
	public NetworkType getNetworkType(){
		return comboBoxNetworkType.getModel().getElementAt(comboBoxNetworkType.getSelectedIndex());
	}
	
	public int getSlots(){
		return (int) spinnerSlots.getValue();
	}
	
	public int getThroughput(){
		return (int) spinnerThroughput.getValue();
	}
	
	public int getStartTime(){
		return (int) spinnerStartTime.getValue();
	}
	
	public Network getNetwork(){
		NetworkType type = getNetworkType();
		
		switch(type){
			case WIFI:
				return Network.getWiFi(getSlots(), getThroughput(), getStartTime());
			case CELLULAR:
				return Network.getCellular(getSlots(), getThroughput());
		}
		
		return null;
	}
}