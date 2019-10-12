package HW4;

import static org.junit.Assert.*;


import org.junit.*;

public class JUnit {

	Pokemon a,b,c,d,e,f,g,h,i,j,k,l,m,n;

	@Before
	public void setUp() {
		a = new Pikachu(-10, -10);
		b = new Charmander(-2, -5);
		c = new Pikachu(10, 50);
		d = new Pikachu(3, 5);
		e = new Charmander(20, 4);
		f = new Charmander(5, 0);
		g = new Charmander(5, 0);
		h = new Pikachu(1, 10);
		i = new Charmander(10, 20);
		j = new Pikachu(100, 8);
		k = new Charmander(100, 7);
		l = new Pikachu(80, 20);
		m = new Charmander(100, 24);
		n = new Vulpix(40, 10);
	}

	@After
	public void tearDown() {
		a = null;
		b = null;
		c = null;
		d = null;
		e = null;
		f = null;
		g = null;
		h = null;
		i = null;
		j = null;
		k = null;
		l = null;
		m = null;
		n = null;
	}

	@Test
	public void TestConstructorsForPikachu() {

		assertEquals(true, a instanceof Pikachu);
		assertEquals(true, a instanceof Pokemon);
		assertEquals(false, a instanceof Charmander);
		assertEquals(false, a instanceof Vulpix);
		assertEquals(Pikachu.class, a.getClass());

	}

	@Test
	public void TestConstructorsForCharmander() {

		assertEquals(true, b instanceof Charmander);
		assertEquals(true, b instanceof Pokemon);
		assertEquals(false, b instanceof Pikachu);
		assertEquals(false, b instanceof Vulpix);
		assertEquals(Charmander.class, b.getClass());

	}
	
	@Test
	public void TestConstructorsForVulpix() {

		assertEquals(true, n instanceof Vulpix);
		assertEquals(true, n instanceof Pokemon);
		assertEquals(false, n instanceof Pikachu);
		assertEquals(false, n instanceof Charmander);
		assertEquals(Vulpix.class, n.getClass());

	}

	@Test
	public void TestInitialFields1() {

		assertEquals(0, a.getHealth());
		assertEquals("Pikachu", a.getName());
		assertEquals(0, a.getPower());

	}

	@Test
	public void TestInitialFields2() {

		assertEquals(0, b.getHealth());
		assertEquals(0, b.getPower());
		assertEquals("Charmander", b.getName());

	}

	@Test
	public void TestInitialFields3() {

		assertEquals(10, c.getHealth());
		assertEquals(50, c.getPower());
		assertEquals("Pikachu", c.getName());

	}

	@Test
	public void TestInitialFields4() {

		assertEquals(3, d.getHealth());
		assertEquals(5, d.getPower());
		assertEquals("Pikachu", d.getName());
		;

	}

	@Test
	public void TestInitialFields5() {

		assertEquals(40, n.getHealth());
		assertEquals(10, n.getPower());
		assertEquals(5, n.getPotions());
		assertEquals(3, n.getEthers());
		assertEquals("Vulpix", n.getName());
		;

	}
	
	@Test
	public void TestSetters1() {

		e.setPower(-2);
		assertEquals(4, e.getPower());

		e.setHealth(-4);
		assertEquals(20,e.getHealth());
		
		d.specialAttack(e);
		assertEquals(15, e.getHealth());
		assertEquals(0, d.getPower());// d lost power since he attacked e
										
		assertEquals("Charmander", e.getName());
		;

	}

	@Test
	public void TestSetters2() {
		
		d.setPower(-1);
		assertEquals(5, d.getPower());
		
		d.setHealth(-10);
		assertEquals(3,d.getHealth());
		
		f.setHealth(5);
		assertEquals(5,f.getHealth());

		f.specialAttack(d);
		assertEquals(3, d.getHealth());
		assertEquals(0, f.getPower());// f lost power since f attacked d 

		assertEquals("Pikachu", d.getName());

	}

	@Test
	public void TestIsDefeated() {
		
		//h = new Pikachu(1, 10, 10);
		//i = new Charmander(10, 20, 5);
		
		assertFalse(h.isDefeated());
		assertTrue(i.specialAttack(h));
		assertTrue(h.isDefeated());
		assertFalse(h.specialAttack(i));
		assertEquals(10, i.getHealth());//h is dead, so it can not attack and should not damage
		assertEquals(10, h.getPower());//h is dead, so h power should be the same
		assertFalse(h.physicalAttack(i));
		assertEquals(10, i.getHealth());//h can not attack
		assertFalse(i.specialAttack(h));
		assertEquals(15, i.getPower());//i can not attack something that is dead, so power should remain
		
	}
	
	
/*	j = new Pikachu(100, 8, 10);
	k = new Charmander(100, 7, 5);*/
	
	@Test
	public void TestAttacks() {
		assertTrue(j.specialAttack(k));
		assertEquals(94, k.getHealth());

		assertTrue(j.specialAttack(k));
		assertEquals(92, k.getHealth());
		
		assertFalse(j.specialAttack(k));
		assertEquals(92, k.getHealth());

		assertTrue(j.physicalAttack(k));
		assertEquals(89, k.getHealth());

		assertTrue(k.specialAttack(j));
		assertEquals(95, j.getHealth());
		
		assertTrue(k.specialAttack(j));
		assertEquals(93, j.getHealth());
		
		assertFalse(k.specialAttack(j));
		assertEquals(93, j.getHealth());

		assertTrue(k.physicalAttack(j));
		assertEquals(89, j.getHealth());
		
		assertEquals(0, j.getPower());
		assertEquals(0, k.getPower());
		
	}
	
	
//	l = new Pikachu(80, 20, 10);
//	m = new Charmander(100, 24, 12);
//	potion += 25
//	ether += 15
	@Test
	public void testPotionsAndEthers() {
		
		assertEquals(5, l.getPotions());
		assertEquals(3, l.getEthers());
		assertEquals(80, l.getHealth());
		assertEquals(20, l.getPower());
		
		l.usePotion();
		l.useEther();
		
		assertEquals(5, l.getPotions());
		assertEquals(3, l.getEthers());
		assertEquals(80, l.getHealth());
		assertEquals(20, l.getPower());
		
		l.specialAttack(m);
		assertEquals(14, l.getPower());
		l.useEther();
		assertEquals(2, l.getEthers());
		assertEquals(20, l.getPower());
		l.specialAttack(m);
		l.specialAttack(m);
		l.specialAttack(m);
		assertEquals(2, l.getPower());
		l.useEther();
		assertEquals(17, l.getPower());
		assertEquals(1, l.getEthers());
		l.specialAttack(m);
		l.specialAttack(m);
		l.specialAttack(m);
		l.specialAttack(m);
		assertEquals(0, l.getPower());
		l.useEther();
		assertEquals(15, l.getPower());
		assertEquals(0, l.getEthers());
		l.specialAttack(m);
		l.specialAttack(m);
		l.specialAttack(m);
		assertEquals(0, l.getPower());
		l.useEther();
		assertEquals(0, l.getPower());
		assertEquals(0, l.getEthers());
		
		assertEquals(44, m.getHealth());
		assertEquals(5, m.getPotions());
		m.usePotion();
		assertEquals(69, m.getHealth());
		assertEquals(4, m.getPotions());
		m.usePotion();
		m.usePotion();
		assertEquals(100, m.getHealth());
		assertEquals(2, m.getPotions());
		m.usePotion();
		assertEquals(100, m.getHealth());
		assertEquals(2, m.getPotions());
		l.physicalAttack(m);
		m.usePotion();
		l.physicalAttack(m);
		m.usePotion();
		assertEquals(100, m.getHealth());
		assertEquals(0, m.getPotions());
		l.physicalAttack(m);
		m.usePotion();
		assertEquals(97, m.getHealth());
		assertEquals(0, m.getPotions());
		
	}
	
	@Test
	public void TestEquals() {
		assertEquals(true, e.equals(e));
		assertEquals(false, e.equals(f));
		assertEquals(false, e.equals(null));
		assertEquals(false, c.equals(f));
		assertEquals(false, e.equals(Integer.valueOf(1)));
		assertEquals(true, f.equals(g));
		assertEquals(true, n.equals(n));
		assertEquals(false, n.equals(e));

	}

	@Test
	public void TestTostring() {
		String cPokemon = c.toString();
		String fPokemon = f.toString();

		int cName = cPokemon.indexOf("Pikachu");
		int cHealth = cPokemon.indexOf("10");
		int cPower = cPokemon.indexOf("50");

		int fName = fPokemon.indexOf("Charmander");
		int fHealth = fPokemon.indexOf("5");
		int fPower = fPokemon.indexOf("0");

		assertEquals(true, cName != -1);
		assertEquals(true, cHealth != -1);
		assertEquals(true, cPower != -1);

		assertEquals(true, fName != -1);
		assertEquals(true, fHealth != -1);
		assertEquals(true, fPower != -1);

	}
	
	@Test
	public void TestMakePokemon() {

		Pokemon p1 = Driver.makePokemon("Pikachu", 10, 10);

		Pokemon p2 = Driver.makePokemon("Charmander", 5, 7);

		Pokemon p3 = Driver.makePokemon("Whatever", 5, 7);
		
		Pokemon p4 = Driver.makePokemon("Vulpix", 15, 10);
		
		Pokemon nullPokemon = Driver.makePokemon(null, 0, 0);

		assertEquals(Pikachu.class, p1.getClass());
		assertEquals(Charmander.class, p2.getClass());
		assertEquals(true, p3==null);
		assertEquals(Vulpix.class, p4.getClass());
		assertTrue(nullPokemon == null);

	}

	@Test
	public void Testexist() {

		Pokemon[][] pokemons = new Pokemon[2][4];
		pokemons[0][0] = a;
		pokemons[0][1] = b;
		pokemons[0][2] = c;
		pokemons[0][3] = d;
		pokemons[1][0] = e;
		pokemons[1][1] = f;
		pokemons[1][2] = g;
		pokemons[1][3] = n;

		boolean arrayContainsA = Driver.contains(a, pokemons);
		boolean arrayContainsB = Driver.contains(b, pokemons);
		boolean arrayContainsC = Driver.contains(c, pokemons);
		boolean arrayContainsD = Driver.contains(d, pokemons);
		boolean arrayContainsE = Driver.contains(e, pokemons);
		boolean arrayContainsF = Driver.contains(f, pokemons);
		boolean arrayContainsG = Driver.contains(g, pokemons);
		boolean arrayContainsN = Driver.contains(n, pokemons);
		boolean arrayContainsI = Driver.contains(i, pokemons);
		boolean arrayContainsJ = Driver.contains(j, pokemons);
		boolean nullValue = Driver.contains(null, pokemons);

		
		assertTrue(arrayContainsA);
		assertTrue(arrayContainsB);
		assertTrue(arrayContainsC);
		assertTrue(arrayContainsD);
		assertTrue(arrayContainsE);
		assertTrue(arrayContainsF);
		assertTrue(arrayContainsG);
		assertTrue(arrayContainsN);
		assertFalse(arrayContainsI);
		assertFalse(arrayContainsJ);
		assertFalse(nullValue);


	}

}
