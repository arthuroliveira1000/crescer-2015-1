/*
1 - Brewdog

Escreva uma função em JS que retorne o número de caracteres diferentes entre dois textos. */

	function brewdog( var1, var2) {

		for(var i  = 0; i < var1.length; i++) {
			for(var j = 0; j < var2.length;  j ++) {
				return Math.abs((var1.charAt(i).match(var2.charAt(j))).length);
			} // -__________________-
		}
	}
