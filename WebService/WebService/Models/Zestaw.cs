﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WebService.Models
{
    public class Zestaw
    {
      public  Pytanie pyt { get; set; }
        public IQueryable<Odpowiedz> odp { get; set; }
    }
}