using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;
using WebService.Models;

namespace WebService.Controllers
{
    public class UzytkowniksController : ApiController
    {
        private DB_A16628_OmnibusEntities db = new DB_A16628_OmnibusEntities();

        // GET: api/Uzytkowniks
        public IQueryable<Uzytkownik> GetUzytkownicy()
        {
            return db.Uzytkownicy;
        }

        // CZY DANE LOGOWANIA SĄ POPRAWNE
        // POST: api/Uzytkowniks/u
        [ResponseType(typeof(Wiadomosc))]
        public Wiadomosc PostUzytkownikLogin(Uzytkownik user)
        {
            Wiadomosc w = new Wiadomosc();
            foreach (Uzytkownik u in db.Uzytkownicy)
            {
                if (u.Haslo == user.Haslo && u.Nazwa == user.Nazwa)
                {
                    w.dane1 = true;
                    w.dane2 = u.IdUzytkownika;
                    return w;
                }
            }
            w.dane1 = false;
            return w;
        }


    //    // GET: api/Uzytkowniks/5
    //    [ResponseType(typeof(Uzytkownik))]
    //    public IHttpActionResult GetUzytkownik(int id)
    //    {
    //        Uzytkownik uzytkownik = db.Uzytkownicy.Find(id);
    //        if (uzytkownik == null)
    //        {
    //            return NotFound();
    //        }

    //        return Ok(uzytkownik);
    //    }

    //    // PUT: api/Uzytkowniks/5
    //    [ResponseType(typeof(void))]
    //    public IHttpActionResult PutUzytkownik(int id, Uzytkownik uzytkownik)
    //    {
    //        if (!ModelState.IsValid)
    //        {
    //            return BadRequest(ModelState);
    //        }

    //        if (id != uzytkownik.IdUzytkownika)
    //        {
    //            return BadRequest();
    //        }

    //        db.Entry(uzytkownik).State = EntityState.Modified;

    //        try
    //        {
    //            db.SaveChanges();
    //        }
    //        catch (DbUpdateConcurrencyException)
    //        {
    //            if (!UzytkownikExists(id))
    //            {
    //                return NotFound();
    //            }
    //            else
    //            {
    //                throw;
    //            }
    //        }

    //        return StatusCode(HttpStatusCode.NoContent);
    //    }

        // POST: api/Uzytkowniks
        [ResponseType(typeof(Wiadomosc))]
        public Wiadomosc PostUzytkownik(Uzytkownik uzytkownik)
        {
            if (!ModelState.IsValid)
            {
                return new Wiadomosc(false);
            }

            db.Uzytkownicy.Add(uzytkownik);
            db.SaveChanges();

            return new Wiadomosc(true);
        }

    //    // DELETE: api/Uzytkowniks/5
    //    [ResponseType(typeof(Uzytkownik))]
    //    public IHttpActionResult DeleteUzytkownik(int id)
    //    {
    //        Uzytkownik uzytkownik = db.Uzytkownicy.Find(id);
    //        if (uzytkownik == null)
    //        {
    //            return NotFound();
    //        }

    //        db.Uzytkownicy.Remove(uzytkownik);
    //        db.SaveChanges();

    //        return Ok(uzytkownik);
    //    }

    //    protected override void Dispose(bool disposing)
    //    {
    //        if (disposing)
    //        {
    //            db.Dispose();
    //        }
    //        base.Dispose(disposing);
    //    }

    //    private bool UzytkownikExists(int id)
    //    {
    //        return db.Uzytkownicy.Count(e => e.IdUzytkownika == id) > 0;
    //    }
    }
}