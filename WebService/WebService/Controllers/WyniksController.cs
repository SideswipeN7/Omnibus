using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using WebService.Models;

namespace WebService.Controllers
{
    public class WyniksController : ApiController
    {
        private DB_A16628_OmnibusEntities db = new DB_A16628_OmnibusEntities();
        // GET: api/Wyniks
        public IEnumerable<WynikGracza> Get()
        {
            List<WynikGracza> wg = new List<WynikGracza>();
            IQueryable<Wynik> qw = db.Wyniki.OrderBy(l => l.Punkty);
            List<Wynik> uniq = new List<Wynik>();
            IQueryable<Uzytkownik> ul = db.Uzytkownicy;


            for (int i = 0; i < qw.ToArray<Wynik>().Length; i++)
            {
                Wynik w = qw.ToArray<Wynik>()[i];
                foreach (Wynik wk in uniq)
                {
                    if (wk.IdUzytkownika != w.IdUzytkownika)
                    {
                        uniq.Add(w);
                    }
                }
            }

            foreach (Wynik w in uniq)
            {
                wg.Add(new WynikGracza() { Punkty = w.Punkty, Gracz = db.Uzytkownicy.Where(l => l.IdUzytkownika == w.IdUzytkownika).Select(l => l.Nazwa).First() });
            }

            int dlug = wg.IndexOf(wg.Last());
            dlug = 10 - dlug;
            if (dlug > 0)
            {
                for(int i = 0; i < dlug + 1; i++)
                {
                    wg.Add(new WynikGracza() { Gracz = "" });
                }
            }

            return wg;
        }

        // GET: api/Wyniks/5
        public string Get(int id)
        {
            return "value";
        }

        // POST: api/Wyniks
        public void Post([FromBody]string value)
        {
        }

        // PUT: api/Wyniks/5
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE: api/Wyniks/5
        public void Delete(int id)
        {
        }
    }
}
