using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Security.Cryptography;
using System.Web.Http;
using System.Web.Http.Description;
using WebService.Models;

namespace WebService.Controllers
{
    public class ZestawsController : ApiController
    {
        private DB_A16628_OmnibusEntities db = new DB_A16628_OmnibusEntities();
        // GET: api/Zestaws
        public IEnumerable<Zestaw> Get()
        {
            //ZRÓB LISTĘ
            IQueryable<Pytanie> pytania = db.Pytania;
            List<Zestaw> zestaw = new List<Zestaw>();
            foreach (Pytanie p in pytania)
            {
                zestaw.Add(new Zestaw() { pyt = p, odp = db.Odpowiedzi.Where(l => l.IdPytania == p.IdPytania) });
            }

            //LOSUJ KOLEJNOŚĆ
            RNGCryptoServiceProvider provider = new RNGCryptoServiceProvider();
            int n = zestaw.Count;
            while (n > 1)
            {
                byte[] box = new byte[1];
                do provider.GetBytes(box);
                while (!(box[0] < n * (Byte.MaxValue / n)));
                int k = (box[0] % n);
                n--;
                Zestaw value = zestaw[k];
                zestaw[k] = zestaw[n];
                zestaw[n] = value;
            }

            //ZWRÓĆ ZESTAW
            return zestaw;
        }


        //PUT: api/Uzytkowniks/5
        [ResponseType(typeof(void))]
        public void PutWynik(Wynik w)
        {
            db.Wyniki.Add(w);
        }


        //PUT: api/Uzytkowniks/5
        [ResponseType(typeof(Wynik))]
        public IEnumerable<Wynik> PutWynik(int x)
        {
            return db.Wyniki.Where(l => l.IdUzytkownika == x);
        }

        // GET: api/Zestaws/5
        public string Get(int id)
        {
            return "value";
        }

        // POST: api/Zestaws
        public void Post([FromBody]string value)
        {
        }

        // PUT: api/Zestaws/5
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE: api/Zestaws/5
        public void Delete(int id)
        {
        }
    }
}
