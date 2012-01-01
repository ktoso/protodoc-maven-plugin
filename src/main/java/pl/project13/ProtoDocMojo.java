package pl.project13;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import pl.project13.protodoc.runner.ProtoDocMain;

/**
 * Goal which generates ProtoDoc.
 *
 * @author <a href="mailto:konrad.malawski@java.pl">Konrad 'ktoso' Malawski</a>
 * @goal package
 * @phase initialize
 * @requiresProject
 * @since 1.0
 */
@SuppressWarnings({"JavaDoc", "UnusedDeclaration"})
public class ProtoDocMojo extends AbstractMojo {

    /**
     * The maven project.
     *
     * @parameter expression="${project}"
     * @readonly
     */
    MavenProject project;


    /**
     * Where are the proto files located?
     *
     * @parameter default-value="${project.basedir}/src/main/proto"
     */
    private String protoDir;

    /**
     * Where are should the docs be generated to?
     *
     * @parameter default-value="${project.basedir}/target/protodoc"
     */
    private String outDir;

    /**
     * Should the plugin print a lot of debug info?
     *
     * @parameter default-value="false"
     */
    private boolean verbose;

    public void execute() throws MojoExecutionException {
        ProtoDocMain.generateProtoDoc(protoDir, outDir, verbose);
    }
}
