﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace WebService.Models
{
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Infrastructure;
    
    public partial class DB_A16628_OmnibusEntities : DbContext
    {
        public DB_A16628_OmnibusEntities()
            : base("name=DB_A16628_OmnibusEntities")
        {
        }
    
        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            throw new UnintentionalCodeFirstException();
        }
    
        public virtual DbSet<Odpowiedz> Odpowiedzi { get; set; }
        public virtual DbSet<Pytanie> Pytania { get; set; }
        public virtual DbSet<Uzytkownik> Uzytkownicy { get; set; }
        public virtual DbSet<Wynik> Wyniki { get; set; }
    }
}
