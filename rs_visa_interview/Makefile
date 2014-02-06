SRC = rs.tex

rs: rs.ps rs.pdf

all: rs.ps rs.pdf

pdf: rs.pdf

rs.ps: rs.dvi
	#dvips -o rs.ps -t letter rs.dvi
	#dvips -P cmz -t letter -o rs.ps rs.dvi
	dvips -t letter -o rs.ps rs.dvi
	#dvips -Pdownload35 -t letter -o rs.ps rs.dvi

rs.pdf: rs.dvi
	#dvips -Ppdf -Pcmz -Pamz -t letter -D 600 -G1 rs.dvi
	dvips -Ppdf -t letter -D 600 -G1 rs.dvi
	ps2pdf14 rs.ps rs.pdf

rs.dvi: $(SRC) rs.blg
	latex rs
	latex rs

rs.blg: rs.bib $(SRC)
	latex rs
	bibtex rs
	latex rs

clean: 
	\rm -f *.dvi *.aux *.ps *~ *.log *.blg *.bbl *.pdf *.eps

clean2:
	\rm -f *.dvi *.aux *.ps *~ *.log *.blg *.bbl *.eps
