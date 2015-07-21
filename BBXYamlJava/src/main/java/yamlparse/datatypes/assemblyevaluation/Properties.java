/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yamlparse.datatypes.assemblyevaluation;

/**
 *
 * @author Mark
 */
public class Properties {
    private Version version;
    private Arguments arguments;
    private Fasta fasta;
    /**
     * TODO: Are these really String-Arrays?
     * 
     */
    private String[] cache; 
    private String[] fasta_dir;
    private String[] id;
    private String[] type;
    private String[] value;

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public Arguments getArguments() {
        return arguments;
    }

    public void setArguments(Arguments arguments) {
        this.arguments = arguments;
    }

    public Fasta getFasta() {
        return fasta;
    }

    public void setFasta(Fasta fasta) {
        this.fasta = fasta;
    }

    public String[] getCache() {
        return cache;
    }

    public void setCache(String[] cache) {
        this.cache = cache;
    }

    public String[] getFasta_dir() {
        return fasta_dir;
    }

    public void setFasta_dir(String[] fasta_dir) {
        this.fasta_dir = fasta_dir;
    }

    public String[] getId() {
        return id;
    }

    public void setId(String[] id) {
        this.id = id;
    }

    public String[] getType() {
        return type;
    }

    public void setType(String[] type) {
        this.type = type;
    }

    public String[] getValue() {
        return value;
    }

    public void setValue(String[] value) {
        this.value = value;
    }
}
