==Test compiling eclipse plug-in using tycho and jenkins==

With the idea to create a full automated workflow.

projects:

* test.maven.swt - the plugin project
* parent.project - the maven parent project (with the tycho settings)

Git configuration

* local git is: /Users/gradle/_SwtBot_Eclipse/workspace
* remote git (gerrit): /home/zen/gerrit/git/SWT.Bot-Eclipse.Plugin.git 