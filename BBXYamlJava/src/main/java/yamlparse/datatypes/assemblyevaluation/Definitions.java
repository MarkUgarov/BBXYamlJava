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
public class Definitions {
    private Fasta fasta;
    private Cache cache;
    private FastaDir fasta_dir;
    private Values values;

    public Fasta getFasta() {
        return fasta;
    }

    public void setFasta(Fasta fasta) {
        this.fasta = fasta;
    }

    public Cache getCache() {
        return cache;
    }

    public void setCache(Cache cache) {
        this.cache = cache;
    }

    public FastaDir getFasta_dir() {
        return fasta_dir;
    }

    public void setFasta_dir(FastaDir fasta_dir) {
        this.fasta_dir = fasta_dir;
    }

    public Values getValues() {
        return values;
    }

    public void setValues(Values values) {
        this.values = values;
    }
}
