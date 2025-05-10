package f.clients.cli;

import org.apache.cli.Options;

import java.lang.module.Configuration;

import org.apache.cli.CommandLine;
import org.apache.cli.HelpFormatter;
import org.apache.cli.Option;
import f.configuration.Configuration;

public abstract class AbstractCustomCommandLine implements CustomCommandLine{
    protected final Option zookeeperNamespaceOption = 
    new Option(
    "z",
    "zookeeperNamespace",
    true,
    "Namespace to create the Zookeeper sub-paths for high availability mode"
    );
    public void addRunOptions(Options baseOptions){
        // nothing to add here
    }
    public void addGeneralOptions(Options baseOptions){
        baseOptions.addOption(zookeeperNamespaceOption);
    }
    public Configuration toConfiguration(CommandLine commandline) throws FlinkException{
        Configuration resultingConfiguration = new Configuration();
        resultingConfiguration.set(DeployOptions.TARGET,RemoteExecutor.NAME);
        if(commandline.hasOption(zookeeperNamespaceOption.getOpt())){
            string zkNamespace = commandline.getOptionValue(zookeeperNamespaceOption.getOpt());
            resultingConfiguration.set(HighAvailabilityOptions.HA_CLUSTER_ID,zkNamespace);
        }
        return resultingConfiguration;
    }
    


}
