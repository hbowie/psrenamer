<?output "../changelog.md"?>
<?nextrec?>
<?definegroup 1 "=$sequence$="?>
<?ifendgroup 1?>

<?ifnewgroup 1?>
Version =$sequence$= (=$duedateymd$=)
-------------------------

<?endif?>
<?if =$status$= gt 5?>
* =$outcome$= 
<?endif?>
<?loop?>
