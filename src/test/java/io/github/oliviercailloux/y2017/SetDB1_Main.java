package io.github.oliviercailloux.y2017;

import io.github.oliviercailloux.y2017.SetDB1_Alternative;
import io.github.oliviercailloux.y2017.SetDB1_AlternativeTree;
import io.github.oliviercailloux.y2017.SetDB1_Criterion;
import io.github.oliviercailloux.y2017.SetDB1_Evaluation;

	/*
	 * Read & Write from DB Alternative, AlternativeTree, Criterion and Evaluation
	 */
public class SetDB1_Main {

   public static void main(String[] args) throws Exception {

	   System.out.println("******Alternative******");
	   
       SetDB1_Alternative dao_alt = new SetDB1_Alternative();
       dao_alt.readDataBase();
       
       System.out.println("******AlternativeTree******");
       
       SetDB1_AlternativeTree dao_alttree = new SetDB1_AlternativeTree();
       dao_alttree.readDataBase();
       
       System.out.println("******Criterion******");
       
       SetDB1_Criterion dao_crit = new SetDB1_Criterion();
       dao_crit.readDataBase();
       
       System.out.println("******Evaluation******");
       
       SetDB1_Evaluation dao_eval = new SetDB1_Evaluation();
       dao_eval.readDataBase();
    }

}