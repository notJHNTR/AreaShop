package me.wiefferink.areashop.commands;

import me.wiefferink.areashop.AreaShop;
import me.wiefferink.areashop.tools.Utils;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class GrouplistCommand extends CommandAreaShop {

	public GrouplistCommand(AreaShop plugin) {
		super(plugin);
	}
	
	@Override
	public String getCommandStart() {
		return "areashop grouplist";
	}
	
	@Override
	public String getHelp(CommandSender target) {
		if(target.hasPermission("areashop.grouplist")) {
			return "help-grouplist";
		}
		return null;
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if(!sender.hasPermission("areashop.grouplist")) {
			plugin.message(sender, "grouplist-noPermission");
			return;
		}
		List<String> groups = plugin.getFileManager().getGroupNames();
		if(groups.size() == 0) {
			plugin.message(sender, "grouplist-noGroups");
		} else {
			plugin.message(sender, "grouplist-success", Utils.createCommaSeparatedList(groups));
		}
	}
	
	@Override
	public List<String> getTabCompleteList(int toComplete, String[] start, CommandSender sender) {
		return new ArrayList<>();
	}

}










