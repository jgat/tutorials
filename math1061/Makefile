all: midsem.pdf

%.pdf: src/%.tex
	pdflatex $<

clean:
	rm midsem.{aux,log,nav,out,snm,toc,pdf}
