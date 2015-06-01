using System;
using System.Dynamic;
using System.Linq;

namespace ConsoleApplication1
{
    class Program
    {
        string _variavel;

        static void Main(String[] args)
        {
            #region dynamic

            dynamic ola = "ta se loco!";
            ola += 10;
            int i = 10;

            dynamic oi = new ExpandoObject();
            oi.saudacao = "ta se loco!";
            Console.WriteLine(oi.saudacao);

            #endregion

            #region Arraii
            var numeros = new[] { 1, 2, 3 };
            numeros.ToList().Add(4);

            /*
            //FOR
            for (int e = 0; e < 10000; e++)
            {
                Console.WriteLine(e);
            }
            //FOREACH
            foreach (var u in numeros)
            {
                Console.WriteLine(u);
            }
            */
            Console.WriteLine("Ana".ToBacon());

            //var numeros = new[] { 1, 2, 3 }.ToList(); -> para poder manipular essa cesta de gatos, tem que tornala uma lista;
            //numeros.AddRange(new[] {4,5}); -> inserir mais numeros na list
            // interfaces em C# começam com I. ex.: IList<int> num = new List<int>();
            //var numeros = new List<int> (capacity: 10);
            //capacity - > para predefinir a capacidade inicial da lista, pode aumentar(elastica)

            #endregion

            # region herança

            var yoda = new Jedi
            {
                Nome = "Yoda"
            };

            //yoda.Nome = "Yoda"; 

            Console.WriteLine(yoda.Nome);

            #endregion


            #region datetime
            DateTime agora = DateTime.Now;
            Console.WriteLine(agora);
            #endregion



            Console.ReadLine();
        }


    }
}