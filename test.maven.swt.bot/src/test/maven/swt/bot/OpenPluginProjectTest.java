package test.maven.swt.bot;

import static org.junit.Assert.*;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swtbot.eclipse.finder.SWTBotEclipseFinderPlugin;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.finders.WorkbenchContentsFinder;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.helpers.SWTBotHelper;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.junit.*;
import org.junit.runner.RunWith;
import org.eclipse.ui.ide.IDE;

@RunWith(SWTBotJunit4ClassRunner.class)
public class OpenPluginProjectTest 
{
	public static SWTWorkbenchBot bot;
	public String projectPath; 
	public String deployProjects;
	
	@BeforeClass
	public final static void beforeClass() throws Exception 
	{				
		bot = new SWTWorkbenchBot();
		assertNotNull(bot);		
	}
	
	public OpenPluginProjectTest()
	{
		projectPath = System.getProperty("user.home") + "/TeamMentor_Eclipse_Plugin";
		deployProjects = System.getProperty("user.home") + "/TeamMentor_Eclipse_Plugin_Deploy";
	}

	@Test
	public void Check_That_Project_Folder_Exists() 
	{		
		System.out.println("Project path: " + projectPath);
		boolean fileExists = new File(projectPath).exists();
		assertTrue("Could not find Folder: " + projectPath, fileExists);
	}
	
	@Test	
	public void open_Deploy_Project()
	{		
		try
		{
			bot.viewByTitle("Welcome").close();
		}
		catch(WidgetNotFoundException ex) {}
		
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("TeamMentor.Update.Site");
		if(project != null && project.exists()==false)
		{
			new SWTBotHelper(bot).openProject(deployProjects, 1)
								 .addDummyTaskToWorkspace();
		}	
		System.out.println("beforeSync");
		Display.getDefault().syncExec(new Runnable() 
			{
				public void run() 
				{
					System.out.println("inside run inside syncExec");
					try 
					 {
						SWTBotView packageExplorer = bot.viewByTitle("Package Explorer");
						SWTBot bot = packageExplorer.bot();
						SWTBotTree tree = bot.tree();
						tree.getAllItems()[0].expand();
						System.out.println("> packageExplorer: " + packageExplorer);
						System.out.println("> bot: " + bot);
						System.out.println("> tree: " + tree);
						System.out.println("*** before getting file data");
						IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("TeamMentor.Update.Site");
						IFile file = project.getFile("site.xml");		 	 
						IWorkbenchPage page = new WorkbenchContentsFinder().activeWorkbenchWindow().getActivePage();
						System.out.println("> project: " + project);
						System.out.println("> file: " + file);
						System.out.println("> page: " + page);
						System.out.println("*** before getting file data");
						
						IDE.openEditor(page, file, true);
						System.out.println("*** after caling editor");
					} catch (Exception e1)//(PartInitException e1) 
					{
						// 
						e1.printStackTrace();
					}
				}
			});

		 //new SWTBotHelper(bot).addDummyTaskToWorkspace();*/
		
		 bot.captureScreenshot("screenshots/open_Deploy_Project.jpeg");
	}
	
	
	//@Test
	public void open_Plugin_Project() 
	{
		//bot.resetWorkbench();
		open_Plugin_Project();

		new SWTBotHelper(bot).openProject(projectPath, 3)
							 .addDummyTaskToWorkspace();//, "TeamMentor.Eclipse.PlugIn.Fortify");				
		
		bot.captureScreenshot("screenshots/open_Test_Project.jpeg");
		
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for(IProject project : projects)
			System.out.println("Current projects: " + project.getName());
	}
	
	 
	@Ignore
	public void open_Plugin_Project_and_Add_UpdateSite()
	{
		
	}
	

	@Test
	@Ignore
	public void check_that_Update_Site_Import_is_Avaialble()
	{
		
	//	SWTBotPreferences.TIMEOUT = 500000;
		SWTBotMenu importMenu = bot.menu("File").menu("Import...");
		importMenu.click();
		SWTBotShell shell = bot.shell("Import");
		assertNotNull(shell);
		shell.activate();
		bot.tree().expandNode("Plug-in Development")
				  .select("Update Site Project");
		shell.close();
	}
	
	
	//Load test project
	//@Ignore
	//@Test
	public void open_Test_Project() 
	{		
		String projectPath = "/Users/zen/Fortify-Plugin/Eclipses/workspaces/test_proj";
				
		new SWTBotHelper(bot).openProject(projectPath,1)
							 .addDummyTaskToWorkspace();		
		

		bot.captureScreenshot("screenshots/open_Test_Project.jpeg");
	}

}
