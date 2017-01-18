SET IDENTITY_INSERT [dbo].[Uzytkownicy] ON
INSERT INTO [dbo].[Uzytkownicy] ([IdUzytkownika], [Nazwa], [Haslo]) VALUES (5, N'User', N'u123')
INSERT INTO [dbo].[Uzytkownicy] ([IdUzytkownika], [Nazwa], [Haslo]) VALUES (6, N'UserA', N'a123')
INSERT INTO [dbo].[Uzytkownicy] ([IdUzytkownika], [Nazwa], [Haslo]) VALUES (7, N'UserB', N'B123')
INSERT INTO [dbo].[Uzytkownicy] ([IdUzytkownika], [Nazwa], [Haslo]) VALUES (8, N'Master', N'm123')
INSERT INTO [dbo].[Uzytkownicy] ([IdUzytkownika], [Nazwa], [Haslo]) VALUES (9, N'OptimusPrime', N'allspark')
INSERT INTO [dbo].[Uzytkownicy] ([IdUzytkownika], [Nazwa], [Haslo]) VALUES (10, N'Megatron95', N'darkspark')
INSERT INTO [dbo].[Uzytkownicy] ([IdUzytkownika], [Nazwa], [Haslo]) VALUES (11, N'Krzysztof', N'Kolumb')
INSERT INTO [dbo].[Uzytkownicy] ([IdUzytkownika], [Nazwa], [Haslo]) VALUES (12, N'RysiekzKlanu', N'umyjRece')
INSERT INTO [dbo].[Uzytkownicy] ([IdUzytkownika], [Nazwa], [Haslo]) VALUES (13, N'Doktor', N'Kto')
SET IDENTITY_INSERT [dbo].[Uzytkownicy] OFF

SET IDENTITY_INSERT [dbo].[Wyniki] ON
INSERT INTO [dbo].[Wyniki] ([IdWyniku], [IdUzytkownika], [Punkty]) VALUES (1, 1, 20)
INSERT INTO [dbo].[Wyniki] ([IdWyniku], [IdUzytkownika], [Punkty]) VALUES (2, 9, 24)
INSERT INTO [dbo].[Wyniki] ([IdWyniku], [IdUzytkownika], [Punkty]) VALUES (3, 8, 23)
INSERT INTO [dbo].[Wyniki] ([IdWyniku], [IdUzytkownika], [Punkty]) VALUES (4, 4, 5)
INSERT INTO [dbo].[Wyniki] ([IdWyniku], [IdUzytkownika], [Punkty]) VALUES (5, 12, 15)
INSERT INTO [dbo].[Wyniki] ([IdWyniku], [IdUzytkownika], [Punkty]) VALUES (6, 8, 5)
INSERT INTO [dbo].[Wyniki] ([IdWyniku], [IdUzytkownika], [Punkty]) VALUES (7, 13, 8)
INSERT INTO [dbo].[Wyniki] ([IdWyniku], [IdUzytkownika], [Punkty]) VALUES (8, 5, 17)
INSERT INTO [dbo].[Wyniki] ([IdWyniku], [IdUzytkownika], [Punkty]) VALUES (9, 11, 19)
INSERT INTO [dbo].[Wyniki] ([IdWyniku], [IdUzytkownika], [Punkty]) VALUES (10, 3, 8)
INSERT INTO [dbo].[Wyniki] ([IdWyniku], [IdUzytkownika], [Punkty]) VALUES (11, 8, 2)
INSERT INTO [dbo].[Wyniki] ([IdWyniku], [IdUzytkownika], [Punkty]) VALUES (12, 4, 3)
INSERT INTO [dbo].[Wyniki] ([IdWyniku], [IdUzytkownika], [Punkty]) VALUES (13, 3, 4)
INSERT INTO [dbo].[Wyniki] ([IdWyniku], [IdUzytkownika], [Punkty]) VALUES (14, 13, 10)
SET IDENTITY_INSERT [dbo].[Wyniki] OFF
