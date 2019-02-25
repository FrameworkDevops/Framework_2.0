import jenkins.model.Jenkins;
import hudson.model.FreeStyleProject;
import hudson.tasks.Shell;

job = Jenkins.instance.createProject(FreeStyleProject, 'test23')
job.buildersList.add(new Shell('echo hello world'))
job.save()
build = job.scheduleBuild2(5, new hudson.model.Cause.UserIdCause())
build.get()
generatedJobs = build.getAction(javaposse.jobdsl.plugin.actions.GeneratedJobsBuildAction).getItems()
// FIXME skip .scheduleBuild2() on Folder jobs

generatedJobs.each { j -> j.scheduleBuild2(5, new hudson.model.Cause.UserIdCause()) }
