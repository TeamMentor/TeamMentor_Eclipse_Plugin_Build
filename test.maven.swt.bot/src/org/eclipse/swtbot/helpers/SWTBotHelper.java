package org.eclipse.swtbot.helpers;

import static org.junit.Assert.*;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.finders.WorkbenchContentsFinder;
import org.eclipse.swtbot.swt.finder.widgets.*;
import org.eclipse.ui.IWorkbench;

public class SWTBotHelper 
{
	public SWTWorkbenchBot bot;
	
	public SWTBotHelper(SWTWorkbenchBot _bot)
	{
		bot = _bot;
	}
	
	public SWTBotHelper openProject(String pathToProjectToOpen, int expectedProjectLength)
	{
		SWTBotMenu importMenu = bot.menu("File").menu("Import...");
		
		assertNotNull(importMenu);
		importMenu.click();
		
		SWTBotShell shell = bot.shell("Import");
		assertNotNull(shell);
		shell.activate();
		
		bot.tree().expandNode("General")
		   		  .select("Existing Projects into Workspace");
		bot.button("Next >").click();
		bot.radio ("Select root directory:").click();
		bot.text  (0).setText(pathToProjectToOpen);
				
		SWTBotButton button = bot.button("Finish");
		SWTBotTree   tree = bot.tree();
		
		tree.setFocus();  								// to trigger the project list
		
		SWTBotTreeItem[] allItems = tree.getAllItems();
		
		assertEquals(expectedProjectLength, allItems.length);
		
		assertTrue  (button.isEnabled());
		button.click();
		
		IWorkbench workbench  = new WorkbenchContentsFinder().activeWorkbenchWindow().getWorkbench();
		assertNotNull(workbench);
		
/*		getWorkspace().run(new IWorkspaceRunnable() {
			public void run(IProgressMonitor monitor) throws CoreException {
			// nothing to do!
			}
			}, new NullProgressMonitor());
		
		*/
		return this;
	}
	
	public SWTBotHelper addDummyTaskToWorkspace()
	{
	
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		
		//IWorkbench workbench  = new WorkbenchContentsFinder().activeWorkbenchWindow().getWorkbench();
		assertNotNull(workspace);
		
		try 
		{
			workspace.run(new IWorkspaceRunnable() 
				{
					public void run(IProgressMonitor monitor) throws CoreException 
					{
						String test = "123";
					// nothing to do!
					}
				}, new NullProgressMonitor());
		} catch (CoreException e) 
		{			// 
			e.printStackTrace();
		}
		return this;
	}
}
