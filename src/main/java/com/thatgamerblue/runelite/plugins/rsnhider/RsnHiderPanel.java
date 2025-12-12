package com.thatgamerblue.runelite.plugins.rsnhider;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.FlatTextField;

public class RsnHiderPanel extends PluginPanel
{
	private final JTextField rsnTextField;
	private final RsnHiderConfig config;
	private final ConfigManager configManager;

	@Inject
	public RsnHiderPanel(RsnHiderConfig config, ConfigManager configManager)
	{
		super();
		this.config = config;
		this.configManager = configManager;

		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0, 0, 10, 0);

		JLabel label = new JLabel("Custom RSN:");
		add(label, c);

		c.gridy++;
		rsnTextField = new JTextField();
		rsnTextField.setText(config.customRsn());
		add(rsnTextField, c);

		c.gridy++;
		JButton updateButton = new JButton("Update");
		updateButton.addActionListener(e -> updateConfig());
		add(updateButton, c);
	}

	private void updateConfig()
	{
		configManager.setConfiguration("rsnhider", "customRsn", rsnTextField.getText());
	}

	public void updateTextField()
	{
		rsnTextField.setText(config.customRsn());
	}
}
