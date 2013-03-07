all: midsem.pdf week2.pdf week3.pdf

%.pdf: src/%.tex
	pdflatex $<

clean:
	rm *.{aux,log,nav,out,snm,toc,pdf}
