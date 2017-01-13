package Classes;

public class Northwest {
	
	public void Calculate(Element matrix){

		//Calculo das basicas
		Element basics = Methods.CalculateBasics(matrix);
		Methods.copyFirst2Second(basics.direction, matrix.direction);


		// variavel temporaria para calculos
		Element temp = new Element();
		Methods.Expand(basics, temp);
		Methods.copyFirst2Second(basics.matrix, temp.matrix);
		Methods.copyFirst2Second(basics.direction, temp.direction);

		// Recalculo dos UVS
		Element UV = Methods.CalculateUV(matrix);
		Element.Mix(matrix, temp);
		Methods.CopyUV(UV, temp);

		// Calculo das nao basicas
		Element Nbasics = Methods.CalculateNBasics(temp);
		Methods.CopyUV(matrix, Nbasics);

		Element OptimumMatrix;
		// calculo da otimizacao
        OptimumMatrix = Methods.CalculateOptimumSolution(Nbasics,matrix,null);
		// Criar caminhos
        
		// Mostrar matrizes
        matrix.PrintAll2("MATRIX PASSADA");
        basics.PrintAll2("BASICAS");
        UV.PrintAll2("UVS RECALCULADOS");
        Nbasics.PrintAll2("NAO BASICAS");
		OptimumMatrix.PrintAll2("RESPOSTA FINAL: OTIMIZADA");
		
		Point smaller = Methods.Smaller(OptimumMatrix);
		if(OptimumMatrix.matrix[smaller.getX()][smaller.getY()] < 0)
			Calculate(OptimumMatrix);
	}
}
